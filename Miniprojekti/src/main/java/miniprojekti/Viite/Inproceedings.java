/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;
import miniprojekti.Viite.validaattorit.InproceedingsValidator;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public class Inproceedings extends Viite{
    private String bibtexkey;
    private String author;
    private String title;
    private String year;
    private String booktitle;
    private String editor;
    private String volnum;
    private String series; 
    private String pages; 
    private String address; 
    private String month; 
    private String organisation; 
    private String publisher; 
    private String note; 
    private String key;

    public Inproceedings(String bibtexkey, String author, String title, String year, String booktitle, String editor, String volnum, String series, String pages, String address, String month, String organisation, String publisher, String note, String key) {
        this.bibtexkey = bibtexkey;
        setFields(author, title, year, booktitle, editor, volnum, series, pages, address, month, organisation, publisher, note, key);
    }

    public final void setFields(String author1, String title1, String year1, String booktitle1, String editor1, String volnum1, String series1, String pages1, String address1, String month1, String organisation1, String publisher1, String note1, String key1) {
        this.author = author1;
        this.title = title1;
        this.year = year1;
        this.booktitle = booktitle1;
        this.editor = editor1;
        this.volnum = volnum1;
        this.series = series1;
        this.pages = pages1;
        this.address = address1;
        this.month = month1;
        this.organisation = organisation1;
        this.publisher = publisher1;
        this.note = note1;
        this.key = key1;
    }
    
    public String getBibtexkey() {
        return bibtexkey;
    }

    public void setBibtexkey(String bibtexkey) {
        this.bibtexkey = bibtexkey;
    }
    
    public String getRefrence(){
        return bibtexkey;
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolnum() {
        return volnum;
    }

    public void setVolnum(String volnum) {
        this.volnum = volnum;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    
    @Override
    public Validator getValidator(){
        return new InproceedingsValidator(this);
    }


    @Override
    public String getType() {
        return "inproceedings";
    }
    
    
}
