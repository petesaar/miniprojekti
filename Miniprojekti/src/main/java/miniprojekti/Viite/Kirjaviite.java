
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
    
    public Kirjaviite(String author, String title, String year, String booktitle){
        if(checkArgs(author, title, year, booktitle)){
            this.author = author;
            this.title = title;
            this.year = year;
            this.booktitle = booktitle;
        } else {
            throw new IllegalArgumentException();
        }        
    }
    
    private boolean checkArgs(String author, String title, String year, String booktitle){
        boolean ret = true;
        
        ret = ret && !author.isEmpty();
        ret = ret && !title.isEmpty();
        ret = ret && !booktitle.isEmpty();
        ret = ret && checkYear(year);
        
        return ret;
    } 
    
    private boolean checkYear(String year){
        if(year.length() == 4)
            return year.matches("(0-9)*");
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
        
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
        
    public boolean setBooktitle(String booktitle){
        if(!booktitle.isEmpty()){
            this.booktitle = booktitle;
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
