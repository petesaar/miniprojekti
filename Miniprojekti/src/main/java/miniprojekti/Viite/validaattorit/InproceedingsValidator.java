/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite.validaattorit;

import java.util.ArrayList;
import miniprojekti.Viite.Inproceedings;

/**
 *
 * @author Iiro
 */
public class InproceedingsValidator extends Validator{
    
    Inproceedings viite;
    
    public InproceedingsValidator(Inproceedings viite){
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
            errors.add("Artikkelin nimi ei saa olla tyhjä.");
            ret = false;
        } if(viite.getBooktitle().isEmpty()){
            errors.add("Kirjan nimi ei saa olla tyhjä.");
            ret = false;
        } if(!checkYear(viite.getYear())){
            errors.add("Vuosiluvun tulee olla nelinumeroinen luku.");
            ret = false;
        }
        
        if(ret) errors = new ArrayList<String>();
        return ret;    
    }
}
