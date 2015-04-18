package miniprojekti.Viite;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public abstract String getAuthor();

    public abstract String getYear();

    public abstract String getTitle();

    public abstract String getPublisher();
    
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
}
