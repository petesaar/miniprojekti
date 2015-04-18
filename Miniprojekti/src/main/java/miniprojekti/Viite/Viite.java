package miniprojekti.Viite;

import java.util.HashMap;
import java.util.Map;
import miniprojekti.Viite.validaattorit.KirjaviiteValidator;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */

public class Viite implements KirjaviiteRajapinta {
    
    private Map<String, String> fields; // kenttien nimet ja arvot tallennetaan HashMap-rakenteeseen
    private String type; // viitetyyppi
    private String bibtexkey;
    
    public Viite (String type, String bibtexkey, HashMap fields)  {
        // TODO: validoitava Validaattori-luokalla esim. Validoi (string viitetyyppi, Viite)
        this.type = type;
        this.bibtexkey = bibtexkey;
        this.fields = fields;
        
    }
    
    public boolean setType(String type){
        // TODO: validoitava Validaattori-luokalla
        if(!type.isEmpty()){
            this.bibtexkey = type;
            return true;
        } 
        return false;
    }
    public boolean setReference(String bibtexkey){
        // TODO: validoitava Validaattori-luokalla
        if(!bibtexkey.isEmpty()){
            this.bibtexkey = bibtexkey;
            return true;
        } 
        return false;
    }
    
    public void setFieldValue (String key, String value){
        // validointi validaattorilla puuttuu
        this.fields.put(key, value);
    }
    
    public String getType (){
        return this.type;
    }
    
    public String getBibtexkey (){
        return this.bibtexkey;
    }
    
    public String getFieldValue (String key){
        return this.fields.get(key);
    }
    
    public Map getFields (){
        return this.fields;
    }
    
    protected void setFields(Map<String, String> fields){
        this.fields = fields;
    }
    
    public String toString(){
        String viite = "\n";
        
        viite += "Reference: "+this.getBibtexkey();
                
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if(!entry.getValue().equals("")){
                viite += "\n"+entry.getKey()+": ";
                viite += entry.getValue();
            }
        }            
 
        return viite;
    }

    @Override
    public String getRefrence() {
        return bibtexkey;
    }

    @Override
    public Validator getValidator() {
        return null;
        // new KirjaviiteValidator(this);
    }

    @Override
    public String getAuthor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPublisher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

       
        
}
