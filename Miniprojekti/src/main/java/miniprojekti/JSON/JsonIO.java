package miniprojekti.JSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import miniprojekti.Viite.Artikkeliviite;
import miniprojekti.Viite.Inproceedings;
import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.Viite;
import org.json.JSONWriter;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

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
    
    public ViiteJoukko lataa() throws Exception{
        ViitejoukkoImpl viitteet = new ViitejoukkoImpl();
        try{
            JSONTokener tokener = new JSONTokener(new FileReader(filename));
            JSONArray array = new JSONArray(tokener);
            for(int i = 0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                String type = object.getString("type");
                if(type.equals("book")){
                    viitteet.save(new Kirjaviite(object.getString("bibtexkey"),object.getString("author"),object.getString("title"),object.getString("year"),object.getString("publisher"),
                                                 object.getString("booktitle"), object.getString("pages"), object.getString("address"),object.getString("volume"),object.getString("number"),
                                                 object.getString("journal")));
                } else if(type.equals("inproceedings")){
                    viitteet.save(new Inproceedings(object.getString("bibtexkey"),object.getString("author"),object.getString("title"),object.getString("year"),object.getString("booktitle"),
                                                    object.getString("editor"),object.getString("volnum"),object.getString("series"),object.getString("pages"),object.getString("address"),
                                                    object.getString("month"),object.getString("organisation"),object.getString("publisher"),object.getString("key"),object.getString("note")));
                } else if(type.equals("article")){
                    viitteet.save(new Artikkeliviite(object.getString("bibtexkey"),object.getString("author"),object.getString("title"),object.getString("journal"),object.getString("year"),
                                                    object.getString("volume"),object.getString("number"),object.getString("pages"),object.getString("month"),object.getString("note"),
                                                    object.getString("key")));
                }
                
            }    
            
            
        } catch (Exception e){
            throw e;
        }
        
        return viitteet;
    }  
}
