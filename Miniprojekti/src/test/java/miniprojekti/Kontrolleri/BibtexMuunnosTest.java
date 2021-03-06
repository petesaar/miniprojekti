package miniprojekti.Kontrolleri;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import miniprojekti.Viite.Viite;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Jeesusteippaajat
 */
public final class BibtexMuunnosTest {

    private final BibtexMuunnos muuntaja = new BibtexMuunnos();

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
    public void testmuunnaViite() {
        Viite kirja = luoViite(luoMap("Martin, Robert",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008"), "Martin09", "book");
        String result = muuntaja.muunnaViite(kirja);
        String expected = "@book{Martin09,\n"
                + "author = {Martin, Robert},\n"
                + "title = {Clean Code: A Handbook of Agile Software Craftsmanship},\n"
                + "year = {2008},\n"
                + "publisher = {Prentice Hall},\n"
                + "}\n";
        assertEquals(expected, result);
    }

    @Test
    public void testmuunnaViiteStringBuilderilla() {
        StringBuilder builder = new StringBuilder();
        Viite kirja = luoViite(luoMap("Martin, Robert",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008"), "Martin09", "book");
        muuntaja.muunnaViite(builder, kirja);
        String result = builder.toString();
        String expected = "@book{Martin09,\n"
                + "author = {Martin, Robert},\n"
                + "title = {Clean Code: A Handbook of Agile Software Craftsmanship},\n"
                + "year = {2008},\n"
                + "publisher = {Prentice Hall},\n"
                + "}\n";
        assertEquals(expected, result);
    }

    @Test
    public void testmuunnaViiteUTF8() {
        String author = "start äÄöÖåÅ end";
        String expectedAuthor = "start \\\"{a}\\\"{A}\\\"{o}\\\"{O}\\r{a}\\r{A} end";
        String title = "test";
        Viite kirja = luoViite(luoMap(author,
                title,
                "Prentice Hall",
                "2008"), "Martin09", "book");
        String result = muuntaja.muunnaViite(kirja);
        String expected = "@book{Martin09,\n"
                + "author = {" + expectedAuthor + "},\n"
                + "title = {" + title + "},\n"
                + "year = {2008},\n"
                + "publisher = {Prentice Hall},\n"
                + "}\n";
        assertEquals(expected, result);
    }
}
