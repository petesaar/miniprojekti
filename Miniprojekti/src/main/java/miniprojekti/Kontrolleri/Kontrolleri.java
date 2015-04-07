
package miniprojekti.Kontrolleri;

import miniprojekti.Viite.Kirjaviite;

/**
 * Luokasta tehdään ohjausolio, joka toimii yhteistyössä muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri {
    
    public Kontrolleri(){
        
    }
    
    public Kirjaviite luoKirjaviite(){
        Kirjaviite uusi = new Kirjaviite();
        return uusi;
    }
    
}
