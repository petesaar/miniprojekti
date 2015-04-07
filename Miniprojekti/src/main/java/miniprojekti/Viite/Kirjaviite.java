
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
    
    public String toString(){
        String viite = "Viite sisältää seuraavat tiedot: ";
        viite += " Author: "+this.getAuthor()+", Year: "+this.getYear()+", Title: "+this.getTitle()+", Publisher: "+this.getPublisher();
        return viite;
    }
}
