package miniprojekti.JSON;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import miniprojekti.Viite.Artikkeliviite;
import miniprojekti.Viite.Inproceedings;
import miniprojekti.Viite.Kirjaviite;
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
            String json = new Gson().toJson(viitteet.getViitteet().toArray());
            filew.write(json);      
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
                luoViite(object, viitteet);    
            }    
            reader.close();
            
        } catch (Exception e){
            return null;
        }
        
        return viitteet;
    }  

    //Valitsee oikean luokan ja luo viitteen.
    private void luoViite(JSONObject object, ViitejoukkoImpl viitteet) throws JSONException {
        String type = object.getString("type");
        if(type.equals("book")){
            luoKirjaviite(viitteet, object);
        } else if(type.equals("inproceedings")){
            luoInproceedings(viitteet, object);
        } else if(type.equals("article")){
            luoArtikkeliviite(viitteet, object);
        }
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
