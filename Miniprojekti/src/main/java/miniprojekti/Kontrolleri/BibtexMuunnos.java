package miniprojekti.Kontrolleri;

import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.KirjaviiteRajapinta;

/**
 *
 * @author Jeesusteippaajat
 */

/** luokka viite-olioiden/-olion muuntamiseksi bibtex-viitteiksi
 *  tallennuksen ja käyttöliittymään (esikatselu bibtex-muodossa)
 */
public class BibtexMuunnos {
    
    private KirjaviiteRajapinta viite;
    
    public BibtexMuunnos (KirjaviiteRajapinta viite) {
        this.viite = viite;
    }
       
    // TODO: tämä on nyt kopiotu ja muokattu metodi BibtexTallentajasta
    public String muunnaBibtexviitteeksi() {
            StringBuilder teksti = new StringBuilder();
            teksti.append("@book{");
            teksti.append(viite.getRefrence());
            teksti.append(",\nauthor = {");
            teksti.append(viite.getAuthor());
            teksti.append("},\ntitle = {");
            teksti.append(viite.getTitle());
            teksti.append("},\nyear = {");
            teksti.append(viite.getYear());
            teksti.append("},\npublisher = {");
            teksti.append(viite.getPublisher());
            teksti.append("},\n}\n");
	    return teksti.toString();
        
    }
    
}
