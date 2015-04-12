
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
        if(!setRequiredFields(reference, author, title, year, publisher)){
            throw new IllegalArgumentException();
        }        
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
     * @throws IllegalArgumentException mikäli jokin pakollisista kentistä on virheellinen.
     */
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
    //Tarkistaa vuosiluvun oikeellisuuden, siis syötteen tulee olla nelinumeroinen luku.
    private boolean checkYear(String year){
        return year.matches("[0-9][0-9][0-9][0-9]");
    }
    
    //Asettaa annetut arvot pakollisille kentille. Palauttaa false, jos jokin parametri on virheellinen. Apumetodi konstruktoreille. 
    private boolean setRequiredFields(String reference, String author, String title, String year, String publisher){
   
        boolean ret = setReference(reference);
        ret &= setAuthor(author);
        ret &= setTitle(title);
        ret &= setYear(year);
        ret &= setPublisher(publisher);
        
        return ret;
    }
    /**
     * @param reference String
     * @return false, jos parametri on tyhjä merkkijono.
     */
    public boolean setReference(String reference){
        if(!reference.isEmpty()){
            this.reference = reference;
            return true;
        } 
        return false;
    }
    
    /**
     * @param author String
     * @return false, jos parametri on tyhjä merkkijono.
     */
    public boolean setAuthor(String author){
        if(!author.isEmpty()){
            this.author = author;
            return true;
        } 
        return false;
    }
    /**
     * @param title String
     * @return false, jos parametri on tyhjä merkkijono.
     */    
    public boolean setTitle(String title){
        if(!title.isEmpty()){
            this.title = title;
            return true;
        } 
        return false;
    }
    
    /**
     * @param year String, nelinumeroinen luku
     * @return false, jos parametri on virheellinen 
     */    
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
    /**
     * @param publisher
     * @return false, jos parametri on tyhjä merkkijono.
     */    
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
        String viite = "Viite sisältää seuraavat tiedot: ";
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