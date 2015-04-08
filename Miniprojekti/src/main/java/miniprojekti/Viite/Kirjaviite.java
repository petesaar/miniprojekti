
package miniprojekti.Viite;

/**
 *
 * @author Jeesusteippaajat
 */
public class Kirjaviite {
    
    private String author;
    private String title;
    private String year;
    private String publisher;
    private String booktitle;
    private String pages;
    private String address;
    private String volume;
    private String number;
    private String journal;
    
    public Kirjaviite(){
        
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
        
    public void setTitle(String title){
        this.title = title;
    }
        
    public void setYear(String year){
        this.year = year;
    }
        
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
        
    public void setBooktitle(String booktitle){
        this.booktitle = booktitle;
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
            
    public String getPublisher(){
        return this.publisher;
    }
    
    public String getBooktitle(){
        return this.booktitle;
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
}
