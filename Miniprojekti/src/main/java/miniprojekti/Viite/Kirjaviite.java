
package miniprojekti.Viite;

/**
 *
 * @author Jeesusteippaajat
 */
public class Kirjaviite implements KirjaviiteRajapinta{
    
    private String reference;
    private String author;
    private String title;
    private String year;
    private String booktitle = "";
    private String publisher;
    private String pages = "";
    private String address = "";
    private String volume = "";
    private String number = "";
    private String journal = "";
    
    /**
     * @param reference Must not be empty.
     * @param author Must not be empty
     * @param title Must not be empty.
     * @param year Must be four-digit number.
     * @param publisher Must not be empty.
     */

    public Kirjaviite () {
    }

    public Kirjaviite(String reference, String author, String title, String year, String publisher){
        if(!setRequiredFields(reference, author, title, year, publisher)){
            throw new IllegalArgumentException();
        }        
    }
    
    public Kirjaviite(String reference, String author, String title, String year, String publisher, String booktitle, String pages, String address, String volume, String number, String journal){
        if(setRequiredFields(reference, author, title, year, publisher)){
            this.booktitle = booktitle;
            this.pages = pages;
            this.address = address;
            this.volume = volume;
            this.number = number;
            this.journal = journal;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean checkYear(String year){
        return year.matches("[0-9][0-9][0-9][0-9]");
    }
    
    private boolean setRequiredFields(String reference, String author, String title, String year, String publisher){
   
        boolean ret = setReference(reference);
        ret &= setAuthor(author);
        ret &= setTitle(title);
        ret &= setYear(year);
        ret &= setPublisher(publisher);
        
        return ret;
    }
    
    public boolean setReference(String reference){
        if(!reference.isEmpty()){
            this.reference = reference;
            return true;
        } 
        return false;
    }
    
    
    public boolean setAuthor(String author){
        if(!author.isEmpty()){
            this.author = author;
            return true;
        } 
        return false;
    }
        
    public boolean setTitle(String title){
        if(!title.isEmpty()){
            this.title = title;
            return true;
        } 
        return false;
    }
        
    public boolean setYear(String year){
        if(checkYear(year)){
            this.year = year;
            return true;
        } 
        return false;
    }
        
    public void setBooktitle(String booktitle){
        this.booktitle = booktitle;
    }
        
    public boolean setPublisher(String publisher){
        if(!publisher.isEmpty()){
            this.publisher = publisher;
            return true;
        } 
        return false;
    }
            
    public void setPages(String pages){
        this.pages = pages;
    }
            
    public void setAddress(String address){
        this.address = address;
    }
            
    public void setVolume(String volume){
        this.volume = volume;
    }
            
    public void setNumber(String number){
        this.number = number;
    }
            
    public void setJournal(String journal){
        this.journal = journal;
    }
    
    
    
    
    public String getAuthor(){
        return this.author;
    }
            
    public String getYear(){
        return this.year;
    }
            
    public String getTitle(){
        return this.title;
    }
            
    public String getBooktitle(){
        return this.booktitle;
    }
    
    public String getPublisher(){
        return this.publisher;
    }
              
    public String getPages(){
        return this.pages;
    }
              
    public String getAddress(){
        return this.address;
    }
              
    public String getVolume(){
        return this.volume;
    }
              
    public String getNumber(){
        return this.number;
    }
              
    public String getJournal(){
        return this.journal;
    }
              
    public String toString(){
        String viite = "Viite sisÃ¤ltÃ¤Ã¤ seuraavat tiedot: ";
        viite += " Author: "+this.getAuthor()+", Year: "+this.getYear()+", Title: "+this.getTitle()
                +", Publisher: "+this.getPublisher()+", Booktitle: "+this.getBooktitle()+", Pages: "
                +this.getPages()+", Address: "+this.getAddress()+", Volume: "+this.getVolume()
                +", Number: "+this.getNumber()+", Journal: "+this.getJournal();
        return viite;
    }

    @Override
    public String getRefrence() {
        return reference;
    }

}