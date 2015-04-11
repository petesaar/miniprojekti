
package miniprojekti.Kontrolleri;

import java.util.ArrayList;
import miniprojekti.Viite.Kirjaviite;

/**
 * Luokasta tehdään ohjausolio, joka toimii yhteistyössä muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri extends Kirjaviite {
    
    private ArrayList <Kirjaviite> kirjaviitteet = new ArrayList();
    
    // 
    public boolean luoViite (Kontrolleri ohjausOlio) {
        Kirjaviite uusi = ohjausOlio;
        //
        kirjaviitteet.add(uusi);
        return true;
    }
    
    // listaa viitteet käyttöliittymää ja tallennusta varten
    public ArrayList listaaViitteet () {
        return kirjaviitteet;
    }
    
    // lisätäänkö metodi viitteiden levytallennusta varten?
    // public void tallennaViitteet () { }
}