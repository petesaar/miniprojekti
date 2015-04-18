
package miniprojekti.Viite.validaattorit;

import java.util.ArrayList;



public abstract class Validator {
    
    protected ArrayList<String> errors;
    
    public abstract boolean validate();
    
    public String[] getErrors(){
        return errors.toArray(new String[errors.size()]);
    }
    
    protected boolean checkYear(String year){
        return year.matches("[0-9][0-9][0-9][0-9]");
    }
    
}
