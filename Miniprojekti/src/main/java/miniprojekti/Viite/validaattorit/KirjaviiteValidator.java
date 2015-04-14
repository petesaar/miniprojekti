package miniprojekti.Viite.validaattorit;

import java.util.ArrayList;
import miniprojekti.Viite.Kirjaviite;


public class KirjaviiteValidator extends Validator{
    
    private ArrayList<String> errors;
    private Kirjaviite viite;
    
    public KirjaviiteValidator(Kirjaviite viite){
        this.viite = viite;
        errors = new ArrayList<String>();
    }

    @Override
    public boolean validate() {
        
        if(viite.getRefrence().isEmpty()){
            errors.add("BibTexKey ei saa olla tyhjä.");
            return false;    
        } if(viite.getAuthor().isEmpty()){
            errors.add("Tekijä ei saa olla tyhjä.");
            return false;
        } if(viite.getTitle().isEmpty()){
            errors.add("Teoksen nimi ei saa olla tyhjä.");
            return false;
        } if(viite.getPublisher().isEmpty()){
            errors.add("Julkaisija ei saa olla tyhjä.");
            return false;
        } if(!checkYear(viite.getYear())){
            errors.add("Vuosiluvun tulee olla nelinumeroinen luku.");
            return false;
        }
        
        return true;    
    }

    @Override
    public String[] getErrors() {
        return errors.toArray(new String[errors.size()]);
    }


    
    
}
