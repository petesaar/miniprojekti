package miniprojekti.Viite.validaattorit;

import java.util.ArrayList;
import miniprojekti.Viite.Kirjaviite;


public class KirjaviiteValidator extends Validator{
    
    private Kirjaviite viite;
    
    public KirjaviiteValidator(Kirjaviite viite){
        this.viite = viite;
        errors = new ArrayList<String>();
    }

    @Override
    public boolean validate() {
        boolean ret = true;
        
        if(viite.getRefrence().isEmpty()){
            errors.add("BibTexKey ei saa olla tyhjä.");
            ret = false;
        } if(viite.getAuthor().isEmpty()){
            errors.add("Tekijä ei saa olla tyhjä.");
            ret = false;
        } if(viite.getTitle().isEmpty()){
            errors.add("Teoksen nimi ei saa olla tyhjä.");
            ret = false;
        } if(viite.getPublisher().isEmpty()){
            errors.add("Julkaisija ei saa olla tyhjä.");
            ret = false;
        } if(!checkYear(viite.getYear())){
            errors.add("Vuosiluvun tulee olla nelinumeroinen luku.");
            ret = false;
        }
        
        if(ret) errors = new ArrayList<String>();
        return ret;    
    }    
    
}
