package miniprojekti.Viite;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public abstract class Viite {

    protected String bibtexkey;
    protected String type;
    
    public String getBibtexkey() {
        return bibtexkey;
    }
     
    public String getRefrence(){
        return bibtexkey;
    }

    public void setBibtexkey(String bibtexkey) {
        this.bibtexkey = bibtexkey;
    }
    
    public abstract Validator getValidator();
    
    public String getType(){
        return type;
    }
    
    public Map<String, String> getFields(){
        HashMap<String, String> fields = new HashMap<String, String>();
        for(Field field: this.getClass().getDeclaredFields()){
            try {
                Object value;
                if ((value = field.get(this)) != null && field.getType().equals(String.class)) {
                    fields.put(field.getName(), value.toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        return fields;
    }
    
    @Override
    public String toString(){
        Map<String, String> fields = this.getFields();
        String teksti = "Bibtex Key: "+bibtexkey+"\n";
        for(String key : fields.keySet()){
            if(!fields.get(key).isEmpty())
                teksti += key+": "+fields.get(key)+"\n";
        }
        return teksti;
    }
}
