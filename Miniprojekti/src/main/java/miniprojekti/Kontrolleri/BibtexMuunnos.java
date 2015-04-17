package miniprojekti.Kontrolleri;

import java.util.Map;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.KirjaviiteRajapinta;

/**
 *
 * @author Jeesusteippaajat
 */

/** luokka viite-olioiden/-olion muuntamiseksi bibtex-viitteiksi
 *  tallennuksen ja käyttöliittymään (esikatselu bibtex-muodossa)
 */
public class BibtexMuunnos {
    
    private Viite viite;
    
    public BibtexMuunnos (Viite viite) {
        this.viite = viite;
    }
       
    // TODO: tämä on nyt kopiotu ja muokattu metodi BibtexTallentajasta
    public String muunnaBibtexviitteeksi() {
            StringBuilder teksti = new StringBuilder();
            teksti.append("@"+viite.getType()+"{");
            teksti.append(viite.getBibtexkey()+",\n");
            Map<String, String> fields = viite.getFields();
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                teksti.append(entry.getKey()+" = {");
                teksti.append(entry.getValue()+",\n");
        }  
            
            teksti.append("}\n");
	    return teksti.toString();
        
    }
    
}
