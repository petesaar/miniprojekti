/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.Viite;

import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Iiro
 */
public class Artikkeliviite extends Viite {
    
    protected String author;
    protected String title;
    protected String journal;
    protected String year;
    protected String volume;
    
    protected String number;
    protected String pages;
    protected String month;
    protected String note;
    protected String key;

    public Artikkeliviite(String bibtexkey, String author, String title, String journal, String year, String volume, String number, String pages, String month, String note, String key) {
        this.bibtexkey = bibtexkey;
        setFields(author, title, journal, year, volume, number, pages, month, note, key);
    }

    public final void setFields(String author1, String title1, String journal1, String year1, String volume1, String number1, String pages1, String month1, String note1, String key1) {
        this.author = author1;
        this.title = title1;
        this.journal = journal1;
        this.year = year1;
        this.volume = volume1;
        this.number = number1;
        this.pages = pages1;
        this.month = month1;
        this.note = note1;
        this.key = key1;
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

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
    public Validator getValidator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return "article";
    }
    
    
}
