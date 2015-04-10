package miniprojekti.Viite;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeesusteippaajat
 */
public class KirjaviiteTest {
    
    private Kirjaviite viite;
    
    public KirjaviiteTest() {
    }
    
    
    @Before
    public void setUp(){
        viite = new Kirjaviite("Author", "Title", "1999", "Bookname");
    }
    
    @Test
    public void nimiEiTyhjaKonstruktorissa(){
        if (tryConstructor("Author","","1999","Bookname"))
            fail("Tyhjän merkkijono title-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test
    public void kirjailijaEiTyhjäKonstruktorissa(){
        if (tryConstructor("","Title","1999","Bookname"))
            fail("Tyhjän merkkijono author-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void kirjannimiEiTyhjäKonstruktorissa(){
        if (tryConstructor("Author","Title","1999",""))
            fail("Tyhjän merkkijono bookname-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void vuosiluvunTuleeOllaNelinumeroinenLuku(){
        String message = "Tyhjän merkkijono bookname-parametrina tulisi aiheuttaa poikkeus.";
        if (tryConstructor("Author","Title","192","Bookname"))
            fail(message);
        if (tryConstructor("Author","Title","19223","Bookname"))
            fail(message);
        if (tryConstructor("Author","Title","19s2","Bookname"))
            fail(message);
        if (tryConstructor("Author","Title","Year","Bookname"))
            fail(message);
    }
    
    @Test
    public void kirjaviiteOlionLuontiOnnistuuHyväksyttävilläParametreilla(){
        if(tryConstructor("Author", "Title", "1999", "Booktitle")){
            return;
        }
        fail("Olion luominen parametreilla (\"Author\", \"Title\", \"1999\", \"Booktitle\") tulisi onnistua! ");
    }
    
    
    @Test
    public void setAuthorEiHyväksyTyhjääMerkkijonoa(){
        if(viite.setAuthor(""))
            fail("SetAuthor: merkkijono ei saa olla tyhjä.");
    }
    
    @Test
    public void setAuthorToimiiEpätyhjälläMerkkijonolla(){
        viite.setAuthor("Pekka");
        assertTrue(viite.getAuthor().equals("Pekka"));
    }
    
    @Test
    public void setTitleEiHyväksyTyhjääMerkkijonoa(){
        if(viite.setTitle(""))
            fail("SetTitle: merkkijono ei saa olla tyhjä.");
    }
    
    @Test
    public void setTitleToimiiEpätyhjälläMerkkijonolla(){
        viite.setTitle("Kirja");
        assertTrue(viite.getTitle().equals("Kirja"));
    }
    
    @Test
    public void setYearEiHyväksyVirheellistäVuosilukua(){
        String message = "SetYear: annetun merkkijonon tulee olla nelinumeroinen luku.";
        if(viite.setYear("Year"))
            fail(message);
        if(viite.setYear(""))
            fail(message);
        if(viite.setYear("123"))
            fail(message);
        if(viite.setYear("20531"))
            fail(message);
    }
    
    @Test
    public void setYearToimiiKäyvälläVuosiluvulla(){
        viite.setYear("1980");
        assertTrue(viite.getYear().equals("1980"));
    }
    
    @Test
    public void setBooktitleEiHyväksyTyhjääMerkkijonoa(){
        if(viite.setBooktitle(""))
            fail("SetBooktitle: merkkijono ei saa olla tyhjä.");
    }
    
    @Test
    public void setBooktitleToimiiEpätyhjälläMerkkijonolla(){
        viite.setBooktitle("Knimi");
        assertTrue(viite.getBooktitle().equals("Knimi"));
    }
    
    
    private boolean tryConstructor(String author, String title, String year, String bookname){
        try{
            Kirjaviite v = new Kirjaviite(author, title, year, bookname);
        } catch(IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
