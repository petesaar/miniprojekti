package miniprojekti.JSON;

import com.google.gson.Gson;
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
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


/**
 * Tallentaa viitteitä JSON-tiedostoon. 
 * @author Jeesusteippaajat
 */

public class JsonIO {
    
    private String filename;
    
    public JsonIO(String filename){
        this.filename = filename;
    }
    /**
     * Tallentaa kaikki viitejoukon viitteet tiedostoon.
     * @param viitteet
     * @return false, jos tallennus epäonnistui.
     */
    public boolean tallenna(ViiteJoukko viitteet){         
        try{   
            FileWriter filew = new FileWriter(filename);
            JSONWriter writer = new JSONWriter(filew);        
            
            writer.array();
            for(Viite viite: viitteet.getViitteet()){
                tallennaViite(writer, viite);
            
            }
            writer.endArray();
            filew.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    
    /**
     * Lataa viitteet tiedostosta. 
     * @return Viitejoukko, jossa ladatut viitteet. Null jos lataaminen epäonnistui.
     */
    public ViiteJoukko lataa(){
        ViitejoukkoImpl viitteet = new ViitejoukkoImpl();
        try{
            FileReader reader = new FileReader(filename);
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray array = new JSONArray(tokener);
            for(int i = 0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                String type = object.getString("type");
                if(type.equals("book")){
                    luoKirjaviite(viitteet, object);
                } else if(type.equals("inproceedings")){
                    luoInproceedings(viitteet, object);
                } else if(type.equals("article")){
                    luoArtikkeliviite(viitteet, object);
                }    
            }    
            reader.close();
            
        } catch (Exception e){
            return null;
        }
        
        return viitteet;
    }  
    
    //Kirjoittaa yhden viitteen jsoniin.
    private void tallennaViite(JSONWriter writer, Viite viite) throws JSONException {
        writer.object().key("type").value(viite.getType());
        writer.key("bibtexkey").value(viite.getBibtexkey());
        Map<String, String> fields = viite.getFields();
        
        for(String key : fields.keySet()){
            writer.key(key).value(fields.get(key));
        }
        writer.endObject();
    }

    //Nämä luovat viiteolion JSONObject-oliosta.
    
    private void luoKirjaviite(ViitejoukkoImpl viitteet, JSONObject object) throws JSONException {
        viitteet.save(new Gson().fromJson(object.toString(), Kirjaviite.class));
    }

    private void luoInproceedings(ViitejoukkoImpl viitteet, JSONObject object) throws JSONException {
        viitteet.save(new Gson().fromJson(object.toString(), Inproceedings.class));
    }

    private void luoArtikkeliviite(ViitejoukkoImpl viitteet, JSONObject object) throws JSONException {
        viitteet.save(new Gson().fromJson(object.toString(), Artikkeliviite.class));
    }
}
