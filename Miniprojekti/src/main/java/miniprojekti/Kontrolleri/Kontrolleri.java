
package miniprojekti.Kontrolleri;

import java.util.ArrayList;
import java.util.List;
import miniprojekti.Viite.Kirjaviite;

/**
 * Luokasta tehdään ohjausolio, joka toimii yhteistyössä muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri {
    
    private List<Kirjaviite> kirjaviitteet = new ArrayList();
    
    // luodaan uusi kirjaviite
    public boolean luoKirjaviite(String reference, String author, String title, 
            String year, String booktitle, String publisher, String pages, String address, 
            String volume, String number, String journal) {
        Kirjaviite viite;
        try {
            // jos viitteen luominen epäonnistuu näyttää kontrolleri näkymälle virheen
            viite = new Kirjaviite(reference, author, title, year, booktitle, 
                        publisher, pages, address, volume, number, journal);
        } catch (Exception e) {
            // TODO: kirjaviite voisi antaa lisätietoa syötteen epäonnistuessa
            return false;
        }
        return kirjaviitteet.add(viite);
    }
    
    // listaa viitteet käyttöliittymää ja tallennusta varten
    public List<Kirjaviite> listaaViitteet () {
        return kirjaviitteet;
    }
    
    // palauta viimeksi lisätty kirjaviite
    public Kirjaviite haeViimeksiLisattyKirjaviite() {
        return kirjaviitteet.get(kirjaviitteet.size() - 1);
    }
    
    // lisätäänkö metodi viitteiden levytallennusta varten
    public void tallennaViitteet () {
        
    }
    
    // metodi luokkien lataamiseen levyltä
    public void haeViitteet () {
        
    }
}