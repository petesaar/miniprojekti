
package miniprojekti.Kontrolleri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miniprojekti.IO.BibtexTallentaja;
import miniprojekti.IO.FileIO;
import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;

/**
 * Luokasta tehdään ohjausolio, joka toimii yhteistyössä muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri {
    
    // 
    private final List<Viite> kirjaviitteet = new ArrayList<Viite>();
    /* TÄMÄ ON VANHA VERSIO, VOI PALAUTTAA 
    private final List<KirjaviiteRajapinta> kirjaviitteet = new ArrayList<KirjaviiteRajapinta>();
    */
    
    // uusi Okon/part-a ehdotus:
    public boolean luoViite(String type, String bibtexkey, HashMap fields) {
        Viite viite;
        try {
            // jos viitteen luominen epäonnistuu näyttää kontrolleri näkymälle virheen
            viite = new Viite(type, bibtexkey, fields);
        } catch (Exception e) {
            // TODO: kirjaviite voisi antaa lisätietoa syötteen epäonnistuessa
            return false;
        }
        return kirjaviitteet.add(viite);
    }
    

    // luodaan uusi kirjaviite
    public boolean luoKirjaviite(String reference, String author, String title, 
            String year, String booktitle, String publisher, String pages, String address, 
            String volume, String number, String journal) {
        Kirjaviite viite;
        try {
            // jos viitteen luominen epäonnistuu näyttää kontrolleri näkymälle virheen
            viite = new Kirjaviite(reference, author, title, year, booktitle, 
                        publisher, pages, address, volume, number, journal);
        } catch (Exception e) {
            // TODO: kirjaviite voisi antaa lisätietoa syötteen epäonnistuessa
            return false;
        }
        return kirjaviitteet.add(viite);
    }

    
    // keskeneräinen hakutoiminto (palauttaa myös viitteen, jos hakusana on kentän nimessä)
    public List<KirjaviiteRajapinta> haeSanalla (String hakusana) {
        List<KirjaviiteRajapinta> hakutulokset = new ArrayList<KirjaviiteRajapinta>();
        for (KirjaviiteRajapinta viite : kirjaviitteet) {
            // TODO: kun viiteluokkaan tehty getFields-metodi tms. niin hakutomintoa tarkennettava
            if (viite.toString().contains(hakusana)) hakutulokset.add(viite);
        }
        return hakutulokset;
    }
    
    // listaa viitteet käyttöliittymää ja tallennusta varten
    // VANHA VERSIO: public List<KirjaviiteRajapinta> listaaViitteet () {
    public List<Viite> listaaViitteet () {
        return kirjaviitteet;
    }
    
    // palauta viimeksi lisätty kirjaviite
    public String haeViimeksiLisattyKirjaviite() {
        if (!kirjaviitteet.isEmpty()) {
            BibtexMuunnos bibtex = new BibtexMuunnos(kirjaviitteet.get(kirjaviitteet.size() - 1));
            return bibtex.muunnaBibtexviitteeksi();
        }
        return null;
    }
    
    /* POISTIN TALLENNUKSEN KÄYTÖSTÄ, KUN LISÄSIN VIITELUOKAN
    // lisätäänkö metodi viitteiden levytallennusta varten?
    public void tallennaViitteet () {
        ViiteJoukko viitteet = new ViiteJoukko() {
            @Override
            public Iterable<KirjaviiteRajapinta> getKirjaViitteet() {
                return kirjaviitteet;
            }
            @Override
            public boolean save(KirjaviiteRajapinta viite) { return false; }
            @Override
            public ArrayList<KirjaviiteRajapinta> getViitteet() { return null; }
            @Override
            public String[] getErrors() { return null; }
        };
        FileIO io = null;
        try {
            io = new FileIO("target/tallennukset.bib");
            BibtexTallentaja tallentaja = new BibtexTallentaja(viitteet);
            tallentaja.tallennaStream(io);
        } catch (IOException ex) {
        } catch (IllegalArgumentException ex) {
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
    }
    */
    
    // metodi luokkien lataamiseen levyltä
    public List<Kirjaviite> haeViitteet () {
        return null;
    }
}