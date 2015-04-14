/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;

import java.util.ArrayList;
import miniprojekti.Viite.validaattorit.Validator;


public class ViitejoukkoImpl implements ViiteJoukko{

    private ArrayList<KirjaviiteRajapinta> viitteet;
    private String[] errors;
    
    public ViitejoukkoImpl(){
        viitteet = new ArrayList<KirjaviiteRajapinta>();
        errors = null;
    }
    
    @Override
    public Iterable<KirjaviiteRajapinta> getKirjaViitteet() {
        return viitteet;
    }

    /**
     * Validoi ja tallentaa viitteen.
     * @param viite
     * @return false jos viitettä ei tallennettu virheellisenä.
     */
    @Override
    public boolean save(KirjaviiteRajapinta viite) {
        Validator validator = viite.getValidator();
        boolean valid = validator.validate();
        if(!valid){
            errors = validator.getErrors();
            return false;
        }
        errors = null;
        viitteet.add(viite);
        return true;
    }

    @Override
    public ArrayList<KirjaviiteRajapinta> getViitteet() {
        return viitteet;
    }

    /**
     * Palauttaa edelliseen transaktioon liittyvät virheet, jos niitä on.
     * @return null jos virheitä ei ole.
     */
    @Override
    public String[] getErrors() {
        return errors;
    }
    
}
