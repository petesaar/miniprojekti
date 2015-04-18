/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite.validaattorit;

import miniprojekti.Viite.Inproceedings;

/**
 *
 * @author Iiro
 */
public class InproceedingsValidator extends Validator{
    
    Inproceedings viite;
    
    public InproceedingsValidator(Inproceedings viite){
        this.viite = viite;
    }
    
    @Override
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
