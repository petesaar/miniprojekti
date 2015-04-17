/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;

import java.util.HashMap;

/**
 *
 * @author Iiro
 */
public class Inproceedings extends Viite{

    public Inproceedings(String bibtexkey, String author, String title, String year, String booktitle) {
        super("inproceedings", bibtexkey, new HashMap<String, String>());
    }
    
}
