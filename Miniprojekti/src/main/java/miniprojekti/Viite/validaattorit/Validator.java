
package miniprojekti.Viite.validaattorit;



public abstract class Validator {
    
    public abstract boolean validate();
    
    public abstract String[] getErrors();
    
    protected boolean checkYear(String year){
        return year.matches("[0-9][0-9][0-9][0-9]");
    }
    
}
