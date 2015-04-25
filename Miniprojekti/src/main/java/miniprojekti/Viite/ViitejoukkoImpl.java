/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;

import java.util.ArrayList;
import miniprojekti.Viite.validaattorit.Validator;


public class ViitejoukkoImpl implements ViiteJoukko{
    
    private ArrayList<Viite> viitteet;
    private String[] errors;
    
    public ViitejoukkoImpl(){
        viitteet = new ArrayList<Viite>();
        errors = null;
    }
    
    @Override
    public Iterable<Viite> getKirjaViitteet() {
        return viitteet;
    }

    /**
     * Validoi ja tallentaa viitteen.
     * @param viite
     * @return false jos viitettä ei tallennettu virheellisenä.
     */
    @Override
    public boolean save(Viite viite) {
        Validator validator = viite.getValidator();
        boolean valid = validator.validate();
        errors = validator.getErrors();
        if(!valid){
            return false;
        }
        viitteet.add(viite);
        return true;
    }
    
    @Override
    public boolean remove(Viite viite){
        viitteet.remove(viite);
        return true;
    }

    @Override
    public ArrayList<Viite> getViitteet() {
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
