package miniprojekti.Viite;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public abstract class KirjaviiteRajapinta {

    protected String bibtexkey;
    
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
    
    public abstract String getType();
    
    public Map<String, String> getFields(){
        HashMap<String, String> fields = new HashMap<String, String>();
        for(Field field: this.getClass().getDeclaredFields()){
            try {
                fields.put(field.getName(), field.get(this).toString());
            } catch (Exception ex) {
                return null;
            }
        }
        return fields;
    }
    
    @Override
    public String toString(){
        Map<String, String> fields = this.getFields();
        String teksti = "Reference "+bibtexkey+":\n";
        for(String key : fields.keySet()){
            if(!fields.get(key).isEmpty())
                teksti += key+": "+fields.get(key)+"\n";
        }
        return teksti;
    }
}
