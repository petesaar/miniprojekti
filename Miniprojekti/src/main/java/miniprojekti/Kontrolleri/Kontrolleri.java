
package miniprojekti.Kontrolleri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import miniprojekti.IO.BibtexTallentaja;
import miniprojekti.IO.FileIO;
import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;

/**
 * Luokasta tehdÃ¤Ã¤n ohjausolio, joka toimii yhteistyÃ¶ssÃ¤ muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri {
    
    // 
    private final ViitejoukkoImpl kirjaviitteet = new ViitejoukkoImpl();
    
    // uusi Okon/part-a ehdotus:
    public boolean luoViite(String type, String bibtexkey, HashMap fields) {
        Viite viite;
        viite = new Viite(type, bibtexkey, fields);

        return kirjaviitteet.save(viite);
    }
    

    // luodaan uusi kirjaviite
    public boolean luoKirjaviite(String reference, String author, String title, 
            String year, String booktitle, String publisher, String pages, String address, 
            String volume, String number, String journal) {
        Kirjaviite viite;
        viite = new Kirjaviite(reference, author, title, year, booktitle, 
                        publisher, pages, address, volume, number, journal);
        return kirjaviitteet.save(viite);
    }

    
    // keskenerÃ¤inen hakutoiminto (palauttaa myÃ¶s viitteen, jos hakusana on kentÃ¤n nimessÃ¤)
    public List<KirjaviiteRajapinta> haeSanalla (String hakusana) {
        List<KirjaviiteRajapinta> hakutulokset = new ArrayList<KirjaviiteRajapinta>();
        for (KirjaviiteRajapinta viite : kirjaviitteet.getViitteet()) {
            // TODO: kun viiteluokkaan tehty getFields-metodi tms. niin hakutomintoa tarkennettava
            if (viite.toString().contains(hakusana)) hakutulokset.add(viite);
        }
        return hakutulokset;
    }
    
    // listaa viitteet kÃ¤yttÃ¶liittymÃ¤Ã¤ ja tallennusta varten
    // VANHA VERSIO: public List<KirjaviiteRajapinta> listaaViitteet () {
    public List<KirjaviiteRajapinta> listaaViitteet () {
        return kirjaviitteet.getViitteet();
    }
    
    // palauta viimeksi lisÃ¤tty kirjaviite
    public String haeViimeksiLisattyKirjaviite() {
        if (!kirjaviitteet.getViitteet().isEmpty()) {
            BibtexMuunnos bibtex = new BibtexMuunnos(kirjaviitteet.getViitteet().get(kirjaviitteet.getViitteet().size() - 1));
            return bibtex.muunnaBibtexviitteeksi();
        }
        return null;
    }
    
    // lisÃ¤tÃ¤Ã¤nkÃ¶ metodi viitteiden levytallennusta varten?
    public void tallennaViitteet () {
        ViiteJoukko viitteet = new ViiteJoukko() {
            @Override
            public Iterable<KirjaviiteRajapinta> getKirjaViitteet() {
                return kirjaviitteet.getKirjaViitteet();
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


    
    // metodi luokkien lataamiseen levyltÃ¤
    public List<Kirjaviite> haeViitteet () {
        return null;
    }
}