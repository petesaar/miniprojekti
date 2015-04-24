package miniprojekti.JSON;

import java.io.FileWriter;
import java.util.Map;
import miniprojekti.Viite.Viite;
import org.json.JSONWriter;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;

/**
 *
 * @author Jeesusteippaajat
 */
public class JsonIO {
    
    private String filename;
    
    public JsonIO(String filename){
        this.filename = filename;
    }
    
    public boolean tallenna(ViiteJoukko viitteet){         
        try{
            
            FileWriter filew = new FileWriter(filename);
            JSONWriter writer = new JSONWriter(filew);        
            
            writer.array();
            for(Viite viite: viitteet.getViitteet()){
                writer.object().key("type").value(viite.getType());
                writer.key("bibtexkey").value(viite.getBibtexkey());
                Map<String, String> fields = viite.getFields();
                
                for(String key : fields.keySet()){
                    writer.key(key).value(fields.get(key));
                }
                writer.endObject();
            
            }
            writer.endArray();
            filew.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public ViiteJoukko lataa(){
        
        return new ViitejoukkoImpl();
    }

    
    
    
}
