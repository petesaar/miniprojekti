package miniprojekti.Viite.validaattorit;

import miniprojekti.Viite.Inproceedings;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class InproceedingsValidatorTest {
    
    Inproceedings viite;
    
    public InproceedingsValidatorTest() {
    }
    
    @Before
    public void setUp() {
        viite = mock(Inproceedings.class);
    }
    
    @Test
    public void validateEiHyväksyJosAuthorTyhjä(){
        expectFalse("ref","","title","year","booktitle");
    }
    
    @Test
    public void validateEiHyväksyJosTitleTyhjä(){
        expectFalse("ref","auth","","year","booktitle");
    }
    
    @Test
    public void validateEiHyväksyJosBooktitleTyhjä(){
        expectFalse("ref","auth","title","year","");
    }
    
    @Test
    public void validateEiHyväksyYearHuono(){
        expectFalse("ref","auth","title","123","booktitle");
        expectFalse("ref","auth","title","123a","booktitle");
        expectFalse("ref","auth","title","12323","booktitle");
    }
    
    @Test
    public void validateHyväksyyHyvilläArvoilla(){
        setReturnValues("ref", "auth", "title", "1234", "booktitle");
        
        InproceedingsValidator validator = new InproceedingsValidator(viite);
        assertTrue(validator.validate());
    }
    
    @Test
    public void getErrorsPalauttaaOikeanMääränVirheitä(){
        expectErrors("ref", "auth", "title", "1234", "booktitle",0);
        expectErrors("ref", "auth", "title", "1234", "",1);
        expectErrors("ref", "auth", "", "", "booktitle",2);
    
    }

    private void setReturnValues(String ref, String auth, String title, String year, String booktitle){
        when(viite.getRefrence()).thenReturn(ref);
        when(viite.getAuthor()).thenReturn(auth);
        when(viite.getTitle()).thenReturn(title);
        when(viite.getYear()).thenReturn(year);
        when(viite.getBooktitle()).thenReturn(booktitle);
    }
    
    private void expectFalse(String ref, String auth, String title, String year, String booktitle){
        setReturnValues(ref, auth, title, year, booktitle);
        
        InproceedingsValidator validator = new InproceedingsValidator(viite);
        assertFalse(validator.validate());
    }
    
    private void expectErrors(String ref, String auth, String title, String year, String booktitle, int numberOfErrors){
        setReturnValues(ref, auth, title, year, booktitle);
        
        InproceedingsValidator validator = new InproceedingsValidator(viite);
        validator.validate();
        
        String[] errors = validator.getErrors();
        if(errors == null){
            if(numberOfErrors == 0) return;
            else fail();
        }
        
        assertTrue("Tulee olla "+numberOfErrors+" virhettä, oli "+errors.length+" virhettä.",errors.length == numberOfErrors);
        
    }
    
}
