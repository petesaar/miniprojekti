package miniprojekti.IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.ViiteJoukko;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Jeesusteippaajat
 */
public final class BibtexTallentajaTest {

    private Iterator<KirjaviiteRajapinta> iteraattori;
    private KirjaviiteRajapinta kirja;
    private Iterable<KirjaviiteRajapinta> viitteetIteraatio;
    private ViiteJoukko viitteet;
    private IOOut out;
    private ByteArrayOutputStream stream;
    private BibtexTallentaja tallentaja;

    @SuppressWarnings("unchecked")
    private void yksiViite() {
        kirja = mock(KirjaviiteRajapinta.class);
        when(kirja.getAuthor()).thenReturn("Beck, Kent and Andres, Cynthia");
        when(kirja.getPublisher()).thenReturn("Addison-Wesley Professional");
        when(kirja.getRefrence()).thenReturn("BA04");
        when(kirja.getTitle()).thenReturn("Extreme Programming Explained: Embrace Change (2nd Edition)");
        when(kirja.getYear()).thenReturn("2004");

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
        tallentaja = new BibtexTallentaja(viitteet);
        try {
            tallentaja.tallennaStream(out);
        } catch (IOException ex) {
            fail(ex.toString());
        }
    }

    /*
     @book{Martin09,
     author = {Martin, Robert},
     title = {Clean Code: A Handbook of Agile Software Craftsmanship},
     year = {2008},
     publisher = {Prentice Hall},
     }
     */
    @SuppressWarnings("unchecked")
    private void kaksiViitetta() {
        kirja = mock(KirjaviiteRajapinta.class);
        when(kirja.getAuthor()).thenReturn("Beck, Kent and Andres, Cynthia", "Martin, Robert");
        when(kirja.getPublisher()).thenReturn("Addison-Wesley Professional", "Prentice Hall");
        when(kirja.getRefrence()).thenReturn("BA04", "Martin09");
        when(kirja.getTitle()).thenReturn("Extreme Programming Explained: Embrace Change (2nd Edition)", "Clean Code: A Handbook of Agile Software Craftsmanship");
        when(kirja.getYear()).thenReturn("2004", "2008");

        iteraattori = mock(Iterator.class);
        when(iteraattori.hasNext()).thenReturn(true, true, false);
        when(iteraattori.next()).thenReturn(kirja, kirja);

        viitteetIteraatio = mock(Iterable.class);
        when(viitteetIteraatio.iterator()).thenReturn(iteraattori);
        viitteet = mock(ViiteJoukko.class);
        when(viitteet.getKirjaViitteet()).thenReturn(viitteetIteraatio);

        stream = new ByteArrayOutputStream();
        out = mock(IOOut.class);
        when(out.getOutputStream()).thenReturn(stream);
        tallentaja = new BibtexTallentaja(viitteet);
        try {
            tallentaja.tallennaStream(out);
        } catch (IOException ex) {
            fail(ex.toString());
        }
    }

    @Test
    public void testTallennus() {
        yksiViite();
        String result = new String(stream.toByteArray(), Charset.forName("UTF-8"));
        String expected = "@book{BA04,\n"
                + "author = {Beck, Kent and Andres, Cynthia},\n"
                + "title = {Extreme Programming Explained: Embrace Change (2nd Edition)},\n"
                + "year = {2004},\n"
                + "publisher = {Addison-Wesley Professional},\n"
                + "}\n";
        assertEquals(expected, result);
    }

    @Test
    public void kaksiViitettaToimii() {
        kaksiViitetta();
        String result = new String(stream.toByteArray(), Charset.forName("UTF-8"));
        String expected = "@book{BA04,\n"
                + "author = {Beck, Kent and Andres, Cynthia},\n"
                + "title = {Extreme Programming Explained: Embrace Change (2nd Edition)},\n"
                + "year = {2004},\n"
                + "publisher = {Addison-Wesley Professional},\n"
                + "}\n"
                + "@book{Martin09,\n"
                + "author = {Martin, Robert},\n"
                + "title = {Clean Code: A Handbook of Agile Software Craftsmanship},\n"
                + "year = {2008},\n"
                + "publisher = {Prentice Hall},\n"
                + "}\n";
        assertEquals(expected, result);
    }

    @Test
    public void iOOutKutsutaan() {
        yksiViite();
        verify(out, times(1)).getOutputStream();
    }

    @Test
    public void viiteKokoelmaaKutsutaan() {
        yksiViite();
        verify(viitteet, times(1)).getKirjaViitteet();
    }

    @Test
    public void viiteKokoelmaNullVirhe() {
        try {
            new BibtexTallentaja(null);
            fail("Null argumentti tallentajaan.");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void iOutNullVirhe() {
        ViiteJoukko tyhjatViitteet = mock(ViiteJoukko.class);
        BibtexTallentaja bibtexTallentaja = new BibtexTallentaja(tyhjatViitteet);
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
        BibtexTallentaja bibtexTallentaja = new BibtexTallentaja(nullViitteet);
        IOOut outTyhja = mock(IOOut.class);
        try {
            bibtexTallentaja.tallennaStream(outTyhja);
            fail("Null viittteet tallenna streamiin.");
        } catch (IllegalArgumentException ex) {
        } catch (IOException ex) {
        }
    }
}
