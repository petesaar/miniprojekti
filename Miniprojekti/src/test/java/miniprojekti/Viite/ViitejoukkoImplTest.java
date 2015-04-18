
package miniprojekti.Viite;

import miniprojekti.Viite.validaattorit.Validator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ViitejoukkoImplTest {
    
    Viite virheellinen;
    Viite kunnollinen;
    Validator virhe;
    Validator ok;
    ViitejoukkoImpl joukko;
    
    public ViitejoukkoImplTest() {
    }
    
    @Before
    public void setUp() {
        virheellinen = mock(Viite.class);
        kunnollinen = mock(Viite.class);
        virhe = mock(Validator.class);
        when(virhe.validate()).thenReturn(false);
        when(virhe.getErrors()).thenReturn(new String[1]);
        ok = mock(Validator.class);
        when(ok.validate()).thenReturn(true);
        when(ok.getErrors()).thenReturn(null);
        when(virheellinen.getValidator()).thenReturn(virhe);
        when(kunnollinen.getValidator()).thenReturn(ok);
        joukko = new ViitejoukkoImpl();
    }

    @Test
    public void savePalauttaaTrueHyväksyttävälläViitteellä() {
        assertTrue(joukko.save(kunnollinen));
    }    
    
    @Test
    public void savePalauttaaFalseVirheelliselläViitteellä(){
        assertFalse(joukko.save(virheellinen));
    }
    
    @Test
    public void saveKutsuuValidaattorinMetodiaGetErrors(){
        joukko.save(kunnollinen);
        verify(ok,times(1)).getErrors();
        
        joukko.save(virheellinen);
        verify(virhe, times(1)).getErrors();
    }
    
    @Test
    public void getErrorsEiPalautaVanhojaVirheitä(){
        joukko.save(virheellinen);
        joukko.save(kunnollinen);
        assertTrue(joukko.getErrors() == null);
    }
    
    
}
