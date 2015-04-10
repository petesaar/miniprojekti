package miniprojekti.Viite;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeesusteippaajat
 */
public class KirjaviiteTest {
    
    public KirjaviiteTest() {
    }
    
    @Test
    public void nimiEiTyhjaKonstruktorissa(){
        try{
            Kirjaviite viite = new Kirjaviite("Author","","1999","Bookname");
        } catch(IllegalArgumentException e){
            return;
        }
        fail("Tyhjän merkkijono title-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test
    public void kirjailijaEiTyhjäKonstruktorissa(){
        try{
            Kirjaviite viite = new Kirjaviite("","Title","1999","Bookname");
        } catch(IllegalArgumentException e){
            return;
        }
        fail("Tyhjän merkkijono author-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void kirjannimiEiTyhjäKonstruktorissa(){
        try{
            Kirjaviite viite = new Kirjaviite("Author","Title","1999","");
        } catch(IllegalArgumentException e){
            return;
        }
        fail("Tyhjän merkkijono bookname-parametrina tulisi aiheuttaa poikkeus.");
    }
    
    @Test 
    public void vuosiluvunTuleeOllaNelinumeroinenLuku(){
        try{
            Kirjaviite viite = new Kirjaviite("Author","Title","192","Bookname");
        } catch(IllegalArgumentException e){
            return;
        }
        fail("Tyhjän merkkijono bookname-parametrina tulisi aiheuttaa poikkeus.");
    }
    
}
