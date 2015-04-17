
package miniprojekti.Viite;

import java.util.HashMap;
import miniprojekti.Viite.validaattorit.KirjaviiteValidator;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public class Kirjaviite extends Viite{
    
    /**Konstruktori vain pakollisilla parametreilla.
     * 
     * @param reference Must not be empty.
     * @param author Must not be empty
     * @param title Must not be empty.
     * @param year Must be a four-digit number.
     * @param publisher Must not be empty.
     * @throws IllegalArgumentException mikäli jokin pakollisista kentistä on virheellinen.
     */
    public Kirjaviite(String reference, String author, String title, String year, String publisher){
        super("book",reference,new HashMap<String, String>());
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("author",author);
        fields.put("year", year);
        fields.put("title",title);
        fields.put("publisher",publisher);
        fields.put("booktitle", "");
        fields.put("pages", "");
        fields.put("address", "");
        fields.put("volume", "");
        fields.put("number", "");
        fields.put("journal", "");
        setFields(fields);
        
    }
    /**Konstruktori kaikilla parametreilla.
     * 
     * @param reference Must not be empty.
     * @param author Must not be empty.
     * @param title Must not be empty.
     * @param year Must be a four-digit number.
     * @param publisher Must not be empty.
     * @param booktitle
     * @param pages
     * @param address
     * @param volume
     * @param number
     * @param journal 
     */
    public Kirjaviite(String reference, String author, String title, String year, String publisher, String booktitle, String pages, String address, String volume, String number, String journal){
        super("book",reference,new HashMap<String, String>());
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("author",author);
        fields.put("year", year);
        fields.put("title",title);
        fields.put("publisher",publisher);
        fields.put("booktitle",booktitle);
        fields.put("pages", pages);
        fields.put("address", address);
        fields.put("volume",volume);
        fields.put("number",number);
        fields.put("journal",journal);
        setFields(fields);
    }

    
    public String getAuthor(){
        return getFieldValue("author");
    }
            
    public String getYear(){
        return getFieldValue("year");
    }
            
    public String getTitle(){
        return getFieldValue("title");
    }
            
    public String getBooktitle(){
        return getFieldValue("booktitle");
    }
    
    public String getPublisher(){
        return getFieldValue("publisher");
    }
              
    public String getPages(){
        return getFieldValue("pages");
    }
              
    public String getAddress(){
        return getFieldValue("address");
    }
              
    public String getVolume(){
        return getFieldValue("volume");
    }
              
    public String getNumber(){
        return getFieldValue("number");
    }
              
    public String getJournal(){
        return getFieldValue("journal");
    }
              
    public String toString(){
        String viite = "\n";
        viite += "Reference: "+this.getRefrence()+"\n"+"Author: "+this.getAuthor()+"\n"+"Year: "+this.getYear()+"\n"+"Title: "+this.getTitle()+"\n"
                +"Publisher: "+this.getPublisher()+"\n";
                
         
        if(!this.getBooktitle().equals("")){
            viite += "Booktitle: "+this.getBooktitle()+"\n";
        }
        if(!this.getPages().equals("")){
            viite += "Pages: "+this.getPages()+"\n";
        }
        if(!this.getAddress().equals("")){
            viite += "Address: "+this.getAddress()+"\n";
        }
        if(!this.getVolume().equals("")){
            viite += "Volume: "+this.getVolume()+"\n";
        } 
        if(!this.getNumber().equals("")){
            viite += "Number: "+this.getNumber()+"\n";
        }
        if(!this.getJournal().equals("")){
            viite += "Journal: "+this.getJournal()+"\n";
        }        
 
        return viite;
    }

    @Override
    public String getRefrence() {
        return getBibtexkey();
    }

    @Override
    public Validator getValidator() {
        return new KirjaviiteValidator(this);
    }


}