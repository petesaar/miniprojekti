/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite.validaattorit;

import miniprojekti.Viite.Artikkeliviite;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class ArtikkeliviiteValidatorTest {
    Artikkeliviite viite;
    
    public ArtikkeliviiteValidatorTest() {
    }
    
    @Before
    public void setUp() {
        viite = mock(Artikkeliviite.class);
    }

    @Test
    public void validateEiHyväksyJosBibtexkeyTyhjä() {
        expectFalse("","auth","title","1234","jour","vol");
    }
    
    @Test
    public void validateEiHyväksyJosAuthorTyhjä() {
        expectFalse("ref","","title","1234","jour","vol");
    }
    
    @Test
    public void validateEiHyväksyJosTitleTyhjä() {
        expectFalse("auth","auth","","1234","jour","vol");
    }
    
    @Test
    public void validateEiHyväksyJosJournalTyhjä(){
        expectFalse("auth","auth","title","1234","","vol");
    }
    
    @Test
    public void validateEiHyväksyJosVolumeTyhjä(){
        expectFalse("auth","auth","title","1234","jour","");
    }
    
    @Test
    public void validateEiHyväksyJosYearVirheellinen(){
        expectFalse("auth","auth","title","123","jour","vol");
        expectFalse("auth","auth","title","123a","jour","vol");
        expectFalse("auth","auth","title","12345","jour","vol");
    }
    
    @Test
    public void validateHyväksyyHyvilläArvoilla(){
        setReturnValues("auth","auth","title","1234","jour","vol");
        
        ArtikkeliviiteValidator validator = new ArtikkeliviiteValidator(viite);
        assertTrue(validator.validate());
    }
    
    @Test
    public void getErrorsPalauttaaOikeanMääränErroreita(){
        
    }
    
    
    
    private void setReturnValues(String ref, String auth, String title, String year, String journal, String volume){
        when(viite.getRefrence()).thenReturn(ref);
        when(viite.getAuthor()).thenReturn(auth);
        when(viite.getTitle()).thenReturn(title);
        when(viite.getYear()).thenReturn(year);
        when(viite.getJournal()).thenReturn(journal);
        when(viite.getVolume()).thenReturn(volume);
    }
    
    private void expectFalse(String ref, String auth, String title, String year, String journal, String volume){
        setReturnValues(ref, auth, title, year, journal, volume);
        
        ArtikkeliviiteValidator validator = new ArtikkeliviiteValidator(viite);
        assertFalse(validator.validate());
    }
    
    private void expectErrors(String ref, String auth, String title, String year, String journal, String volume, int numberOfErrors){
        setReturnValues(ref, auth, title, year, journal, volume);
        
        ArtikkeliviiteValidator validator = new ArtikkeliviiteValidator(viite);
        validator.validate();
        
        String[] errors = validator.getErrors();
        if(errors == null){
            if(numberOfErrors == 0) return;
            else fail();
        }
        
        assertTrue("Tulee olla "+numberOfErrors+" virhettä, oli "+errors.length+" virhettä.",errors.length == numberOfErrors);
        
    }
}
