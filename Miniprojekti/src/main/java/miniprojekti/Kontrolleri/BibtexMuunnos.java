package miniprojekti.Kontrolleri;

import java.util.Map;
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
       
    // Toimii: kääntää minkä tahansa viitetyypin bibtexiksi, mutta testit puuttuvat!
    public String muunnaBibtexviitteeksi() {
            StringBuilder teksti = new StringBuilder();
            teksti.append("@"+viite.getType()+"{");
            teksti.append(viite.getBibtexkey()+",\n");
            Map<String, String> fields = viite.getFields();
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                if(!entry.getValue().isEmpty()){
                    teksti.append(entry.getKey()+" = {");
                    teksti.append(entry.getValue()+",\n");
                }
        }  
            
            teksti.append("}\n");
	    return teksti.toString();
        
    }
    
}
