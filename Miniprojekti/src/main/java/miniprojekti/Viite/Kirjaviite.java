
package miniprojekti.Viite;

import miniprojekti.Viite.validaattorit.KirjaviiteValidator;
import miniprojekti.Viite.validaattorit.Validator;


public class Kirjaviite extends Viite {
 
    protected String author;
    protected String title;
    protected String year;
    protected String publisher;
    protected String booktitle;
    protected String pages;
    protected String address;
    protected String volume;
    protected String number;
    protected String journal;

    public Kirjaviite(String bibtexkey, String author, String title, String year, String publisher, String booktitle, String pages, String address, String volume, String number, String journal) {
        this.bibtexkey = bibtexkey;
        setFields(author, title, year, publisher, booktitle, pages, address, volume, number, journal);
    }

    public final void setFields(String author1, String title1, String year1, String publisher1, String booktitle1, String pages1, String address1, String volume1, String number1, String journal1) {
        this.author = author1;
        this.title = title1;
        this.year = year1;
        this.publisher = publisher1;
        this.booktitle = booktitle1;
        this.pages = pages1;
        this.address = address1;
        this.volume = volume1;
        this.number = number1;
        this.journal = journal1;
    }
    
    @Override
    public Validator getValidator() {
        return new KirjaviiteValidator(this);
    }

    @Override
    public String getType() {
        return "book";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    
    
    
}
