package miniprojekti.IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import miniprojekti.Kontrolleri.Muuntaja;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * @author Jeesusteippaajat
 */
public final class MuuntavaTallentajaTest {

    private Muuntaja muuntaja;
    private Iterator<Viite> iteraattori;
    private Viite kirja;
    private Viite kirja2;
    private Iterable<Viite> viitteetIteraatio;
    private ViiteJoukko viitteet;
    private IOOut out;
    private ByteArrayOutputStream stream;
    private MuuntavaTallentaja tallentaja;

    @After
    public void after() throws IOException {
        if (stream != null) {
            stream.close();
        }
    }

    @Before
    public void before() {
        muuntaja = mock(Muuntaja.class);
        //Nulleja turhaan?
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                StringBuilder sb = (StringBuilder) args[0];
                Viite viite = (Viite) args[1];
                sb.append("Args").append(viite);
                return null;
            }
        }).when(muuntaja).muunnaViite(null, null);
    }

    private String expected() {
        StringBuilder sb = new StringBuilder();
        muuntaja.muunnaViite(sb, kirja);
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void yksiViite(String author, String title, String publisher, String year) {
        Map<String, String> arvot = luoMap(author, title, publisher, year);

        kirja = mock(Viite.class);
        when(kirja.getFields()).thenReturn(arvot);

        iteraattori = mock(Iterator.class);
        when(iteraattori.hasNext()).thenReturn(true, false);
        when(iteraattori.next()).thenReturn(kirja);

        viitteetIteraatio = mock(Iterable.class);
        when(viitteetIteraatio.iterator()).thenReturn(iteraattori);
        viitteet = mock(ViiteJoukko.class);
        when(viitteet.getKirjaViitteet()).thenReturn(viitteetIteraatio);

        stream = new ByteArrayOutputStream();
        out = mock(IOOut.class);
        when(out.getOutputStream()).thenReturn(stream);
        tallentaja = new MuuntavaTallentaja(viitteet, muuntaja);
        try {
            tallentaja.tallennaStream(out);
        } catch (IOException ex) {
            fail(ex.toString());
        }
    }

    private void yksiViiteSpeksistä() {
        yksiViite("Beck, Kent and Andres, Cynthia",
                "Extreme Programming Explained: Embrace Change (2nd Edition)",
                "Addison-Wesley Professional",
                "2004");
    }

    private static Map<String, String> luoMap(String author, String title, String publisher, String year) {
        Map<String, String> arvot = new HashMap<String, String>();
        arvot.put("author", author);
        arvot.put("year", year);
        arvot.put("title", title);
        arvot.put("publisher", publisher);
        return arvot;
    }

    @SuppressWarnings("unchecked")
    private void kaksiViitetta() {
        Map<String, String> arvot1 = luoMap("Beck, Kent and Andres, Cynthia",
                "Extreme Programming Explained: Embrace Change (2nd Edition)",
                "Addison-Wesley Professional",
                "2004"
        );
        Map<String, String> arvot2 = luoMap("Martin, Robert",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008"
        );
        kirja = mock(Viite.class);
        when(kirja.getFields()).thenReturn(arvot1);
        kirja2 = mock(Viite.class);
        when(kirja.getFields()).thenReturn(arvot2);

        iteraattori = mock(Iterator.class);
        when(iteraattori.hasNext()).thenReturn(true, true, false);
        when(iteraattori.next()).thenReturn(kirja, kirja2);

        viitteetIteraatio = mock(Iterable.class);
        when(viitteetIteraatio.iterator()).thenReturn(iteraattori);
        viitteet = mock(ViiteJoukko.class);
        when(viitteet.getKirjaViitteet()).thenReturn(viitteetIteraatio);

        stream = new ByteArrayOutputStream();
        out = mock(IOOut.class);
        when(out.getOutputStream()).thenReturn(stream);
        tallentaja = new MuuntavaTallentaja(viitteet, muuntaja);
        try {
            tallentaja.tallennaStream(out);
        } catch (IOException ex) {
            fail(ex.toString());
        }
    }

    @Test
    public void testTallennus() {
        yksiViiteSpeksistä();
        String result = new String(stream.toByteArray(), MuuntavaTallentaja.CHARSET);
        String expected = expected();
        assertEquals(expected, result);
    }

    @Test
    public void testTallennusUTF8() {
        String author = "ÅÖÅÖÄSA DO#¤OASPDO APS";
        String title = "ASDÅ¤+´´´ökmakwmäeq342¨ö 52 f+d*-- ";
        String year = "1234";
        String publisher = "ÅÅÅÅÅ=*-/-+gF KODJFGISHG93425U5 44213%?#&)\"\"\"\"";
        yksiViite(author, title, publisher, year);
        String result = new String(stream.toByteArray(), MuuntavaTallentaja.CHARSET);
        String expected = expected();
        assertEquals(expected, result);
    }

    @Test
    public void kaksiViitettaToimii() {
        kaksiViitetta();
        String result = new String(stream.toByteArray(), MuuntavaTallentaja.CHARSET);
        String expected = expected();
        assertEquals(expected, result);
    }

    @Test
    public void iOOutKutsutaan() {
        yksiViiteSpeksistä();
        verify(out, times(1)).getOutputStream();
    }

    @Test
    public void viiteKokoelmaaKutsutaan() {
        yksiViiteSpeksistä();
        verify(viitteet, times(1)).getKirjaViitteet();
    }

    @Test
    public void viiteKokoelmaNullVirhe() {
        try {
            new MuuntavaTallentaja(null, mock(Muuntaja.class));
            fail("Null argumentti tallentajaan.");
        } catch (IllegalArgumentException ex) {
            if (!"Vitteet oli null.".equals(ex.getMessage())) {
                fail("Väärä virhe");
            }
        }
    }

    @Test
    public void muuntajaNullVirhe() {
        try {
            new MuuntavaTallentaja(mock(ViiteJoukko.class), null);
            fail("Null argumentti tallentajaan.");
        } catch (IllegalArgumentException ex) {
            if (!"Muuntaja oli null.".equals(ex.getMessage())) {
                fail("Väärä virhe");
            }
        }
    }

    @Test
    public void asdVirhe() {
        try {
            new MuuntavaTallentaja(mock(ViiteJoukko.class), mock(Muuntaja.class));
        } catch (IllegalArgumentException ex) {
            fail(ex.toString());
        }
    }

    @Test
    public void iOutNullVirhe() {
        ViiteJoukko tyhjatViitteet = mock(ViiteJoukko.class);
        MuuntavaTallentaja bibtexTallentaja = new MuuntavaTallentaja(tyhjatViitteet, muuntaja);
        try {
            bibtexTallentaja.tallennaStream(null);
            fail("Null argumentti tallenna streamiin.");
        } catch (IllegalArgumentException ex) {
        } catch (IOException ex) {
        }
    }

    @Test
    public void viitteetIteraatioNullVirhe() {
        ViiteJoukko nullViitteet = mock(ViiteJoukko.class);
        when(nullViitteet.getKirjaViitteet()).thenReturn(null);
        MuuntavaTallentaja bibtexTallentaja = new MuuntavaTallentaja(nullViitteet, mock(Muuntaja.class));
        IOOut outTyhja = mock(IOOut.class);
        try {
            bibtexTallentaja.tallennaStream(outTyhja);
            fail("Null viittteet tallenna streamiin.");
        } catch (IllegalArgumentException ex) {
        } catch (IOException ex) {
        }
    }
}
