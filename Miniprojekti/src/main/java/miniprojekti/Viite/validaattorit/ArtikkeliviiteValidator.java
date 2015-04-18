/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite.validaattorit;

import java.util.ArrayList;
import miniprojekti.Viite.Artikkeliviite;

/**
 *
 * @author Iiro
 */
public class ArtikkeliviiteValidator extends Validator{

    private final Artikkeliviite viite;

    public ArtikkeliviiteValidator(Artikkeliviite viite) {
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
        } if(viite.getJournal().isEmpty()){
            errors.add("Julkaisu ei saa olla tyhjä.");
            ret = false;
        } if(viite.getVolume().isEmpty()){
            errors.add("Numero ei saa olla tyhjä.");
            ret = false;
        } if(!checkYear(viite.getYear())){
            errors.add("Vuosiluvun tulee olla nelinumeroinen luku.");
            ret = false;
        }
        
        if(ret) errors = new ArrayList<String>();
        return ret;   
    }
    
}
