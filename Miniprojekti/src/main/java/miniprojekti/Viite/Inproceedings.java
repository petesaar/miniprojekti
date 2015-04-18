/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;

import java.util.HashMap;
import miniprojekti.Viite.validaattorit.InproceedingsValidator;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public class Inproceedings extends Viite{

    public Inproceedings(String bibtexkey, String author, String title, String year, String booktitle) {
        super("inproceedings", bibtexkey, new HashMap<String, String>());
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("author", author);
        fields.put("year", year);
        fields.put("title",title);
        fields.put("booktitle", booktitle);
        setFields(fields);
        
    }
    
    public Inproceedings(String bibtexkey, String author, String title, String year, String booktitle, String editor, String volnum, String series, String pages, String address, String month, String organisation, String publisher, String note, String key) {
        super("inproceedings", bibtexkey, new HashMap<String, String>());
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("author", author);
        fields.put("year", year);
        fields.put("title",title);
        fields.put("booktitle", booktitle);
        fields.put("editor", editor);
        fields.put("volume/number", volnum);
        fields.put("series", series);
        fields.put("pages", pages);
        fields.put("address", address);
        fields.put("month", month);
        fields.put("organisation", organisation);
        fields.put("publisher", publisher);
        fields.put("note", note);
        fields.put("key", key);
        
        setFields(fields);
        
    }
    
    @Override
    public Validator getValidator(){
        return new InproceedingsValidator(this);
    }
    
    
}
