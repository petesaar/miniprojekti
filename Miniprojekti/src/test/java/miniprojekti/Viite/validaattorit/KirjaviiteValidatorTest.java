package miniprojekti.Viite.validaattorit;

import miniprojekti.Viite.Kirjaviite;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class KirjaviiteValidatorTest {
    
    Kirjaviite viite;
    
    public KirjaviiteValidatorTest() {
    }
    
    @Before
    public void setUp() {
        viite = mock(Kirjaviite.class);
    }

    @Test
    public void validatePalauttaaTrueVirheettömälläViitteellä() {
        setReturnValues("ref","auth","title","pub","1999");
        
        KirjaviiteValidator validator = new KirjaviiteValidator(viite);
        assertTrue(validator.validate());
    }
    
    @Test
    public void validatePalauttaaFalseJosReferenceTyhjä(){
        expectFalse("","auth","title","pub","1999");

    }
    
    @Test
    public void validatePalauttaaFalseJosAuthorTyhjä() {
        expectFalse("ref","","title","pub","1999");
    }
    
    @Test
    public void validatePalauttaaFalseJosTitleTyhjä(){
        expectFalse("ref","auth","","pub","1999");
    }
    
    @Test
    public void validatePalauttaaFalseJosPublisherTyhjä(){
        expectFalse("ref","auth","title","","1999");
    }
    
    @Test
    public void validatePalauttaaFalseJosYearVirheeellinen(){
        expectFalse("ref","auth","title","pub","199a");
        expectFalse("ref","auth","title","pub","199");
        expectFalse("ref","auth","title","pub","19999");
        expectFalse("ref","auth","title","pub","");
        expectFalse("ref","auth","title","pub","asda");
    }
    
    @Test
    public void getErrorsPalauttaaNullJosEiVirheitä(){
        expectErrors("ref","auth","title","pub","1999",0);
    }
    
    @Test 
    public void getErrorsPalauttaaOikeanMääränVirheitä1(){
        expectErrors("ref","auth","title","pub","199",1);
        expectErrors("ref","auth","title","","1999",1);
        expectErrors("ref","auth","","pub","1999",1);
        expectErrors("ref","","title","pub","1999",1);
        expectErrors("","auth","title","pub","1999",1);
    }
    
    @Test 
    public void getErrorsPalauttaaOikeanMääränVirheitä2(){
        expectErrors("ref","auth","title","","199",2);
        expectErrors("ref","","","pub","1999",2);
        expectErrors("ref","auth","","","a24d",3);
    }
    
    @Test 
    public void getErrorsPalauttaaOikeanMääränVirheitä3(){
       expectErrors("ref","","title","","19299",3);
       expectErrors("","","","","1991",4);
       expectErrors("","","","","",5);
    }
    
    private void setReturnValues(String ref, String auth, String title, String pub, String year){
        when(viite.getRefrence()).thenReturn(ref);
        when(viite.getAuthor()).thenReturn(auth);
        when(viite.getTitle()).thenReturn(title);
        when(viite.getPublisher()).thenReturn(pub);
        when(viite.getYear()).thenReturn(year);
    }
    
    private void expectFalse(String ref, String auth, String title, String pub, String year){
        setReturnValues(ref, auth, title, pub, year);
        
        KirjaviiteValidator validator = new KirjaviiteValidator(viite);
        assertFalse(validator.validate());
    }
    
    private void expectErrors(String ref, String auth, String title, String pub, String year, int numberOfErrors){
        setReturnValues(ref, auth, title, pub, year);
        
        KirjaviiteValidator validator = new KirjaviiteValidator(viite);
        validator.validate();
        
        String[] errors = validator.getErrors();
        if(errors == null){
            if(numberOfErrors == 0) return;
            else fail();
        }
        
        assertTrue("Tulee olla "+numberOfErrors+" virhettä, oli "+errors.length+" virhettä.",errors.length == numberOfErrors);
        
    }
}
