package miniprojekti.Kontrolleri;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Jeesusteippaajat
 */
public final class KontrolleriTest {

    private final ViiteJoukko kirjaviitteet = new ViitejoukkoImpl();

    @SuppressWarnings("unchecked")
    private static Map<String, String> luoMap(String author, String title, String publisher, String year) {
        Iterator<Map.Entry<String, String>> avainIteraattori = mock(Iterator.class);
        when(avainIteraattori.hasNext()).thenReturn(true, true, true, true, true, false);
        when(avainIteraattori.next())
                .thenReturn(new AbstractMap.SimpleEntry<String, String>("author", author))
                .thenReturn(new AbstractMap.SimpleEntry<String, String>("title", title))
                .thenReturn(new AbstractMap.SimpleEntry<String, String>("year", year))
                .thenReturn(new AbstractMap.SimpleEntry<String, String>("publisher", publisher))
                .thenReturn(new AbstractMap.SimpleEntry<String, String>("", ""));

        Set<Map.Entry<String, String>> avaimet = mock(Set.class);
        when(avaimet.iterator()).thenReturn(avainIteraattori);

        Map<String, String> arvot = mock(HashMap.class);
        when(arvot.entrySet()).thenReturn(avaimet);
        return arvot;
    }

    private Viite luoViite(Map<String, String> arvot, String bibTeXKey, String type) {
        Viite kirja = mock(Viite.class);
        when(kirja.getFields()).thenReturn(arvot);
        when(kirja.getBibtexkey()).thenReturn(bibTeXKey);
        when(kirja.getType()).thenReturn(type);
        return kirja;
    }

    /*
     @book{Martin09,
     author = {Martin, Robert},
     title = {Clean Code: A Handbook of Agile Software Craftsmanship},
     year = {2008},
     publisher = {Prentice Hall},
     }
     */
    
    @Test
    public void testbibtexkeytUniikkeja() {
        Viite kirja = luoViite(luoMap("Martin, Robert",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008"), "Martin09", "book");
        Viite toinenkirja = luoViite(luoMap("Martin, Don",
                "Kootut",
                "Semic",
                "2009"), "Martin09", "book");

        String result = toinenkirja.getBibtexkey();
        String expected = "Martin09";
        assertEquals(expected, result);
    }
}