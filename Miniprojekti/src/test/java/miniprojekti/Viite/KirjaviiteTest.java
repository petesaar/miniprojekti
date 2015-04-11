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
        viite = new Kirjaviite("Ref","Author", "Title", "1999", "Publisher");
    }
    
    @Test
    public void nimiEiTyhjaKonstruktorissa(){
        if (tryConstructor("Ref","Author","","1999","Publisher"))
            fail("Tyhjän merkkijono title-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test
    public void kirjailijaEiTyhjäKonstruktorissa(){
        if (tryConstructor("Ref","","Title","1999","Publisher"))
            fail("Tyhjän merkkijono author-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void julkaisijaEiTyhjäKonstruktorissa(){
        if (tryConstructor("Ref","Author","Title","1999",""))
            fail("Tyhjän merkkijono bookname-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void vuosiluvunTuleeOllaNelinumeroinenLuku(){
        String message = "Virheellisen vuosiluvun tulee aiheuttaa poikkeus";
        if (tryConstructor("Ref","Author","Title","192","Publisher"))
            fail(message);
        if (tryConstructor("Ref","Author","Title","19223","Publisher"))
            fail(message);
        if (tryConstructor("Ref","Author","Title","19s2","Publisher"))
            fail(message);
        if (tryConstructor("Ref","Author","Title","Year","Publisher"))
            fail(message);
    }
    
    @Test
    public void kirjaviiteOlionLuontiOnnistuuHyväksyttävilläParametreilla(){
        if(tryConstructor("Ref","Author", "Title", "1999", "Publisher")){
            return;
        }
        fail("Olion luominen parametreilla (\"Ref\", \"Author\", \"Title\", \"1999\", \"Publisher\") tulisi onnistua! ");
    }
    
    @Test 
    public void kirjaviitteenLuominenEiOnnistuTyhjälläViitteellä(){
        if(tryConstructor("","Author", "Title", "1999", "Publisher"))
            fail("Tyhjän merkkijonon reference-parametrina tulisi aiheuttaa poikkeus.");
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
    public void setPublisherEiHyväksyTyhjääMerkkijonoa(){
        if(viite.setPublisher(""))
            fail("setPublisher: merkkijono ei saa olla tyhjä.");
    }
    
    @Test
    public void setPublisherToimiiEpätyhjälläMerkkijonolla(){
        viite.setPublisher("Knimi");
        assertTrue(viite.getPublisher().equals("Knimi"));
    }
    
    
    private boolean tryConstructor(String reference, String author, String title, String year, String publisher){
        try{
            Kirjaviite v = new Kirjaviite(reference, author, title, year, publisher);
        } catch(IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
