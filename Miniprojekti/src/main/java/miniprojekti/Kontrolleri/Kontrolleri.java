
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
 * Luokasta tehdÃ¤Ã¤n ohjausolio, joka toimii yhteistyÃ¶ssÃ¤ muiden luokkien kanssa
 * @author Jeesusteippaajat 
 */
public class Kontrolleri {
    
    // 
    private final ArrayList<KirjaviiteRajapinta> kirjaviitteet = new ArrayList<KirjaviiteRajapinta>();
    /* TÃ„MÃ„ ON VANHA VERSIO, VOI PALAUTTAA 
    private final List<KirjaviiteRajapinta> kirjaviitteet = new ArrayList<KirjaviiteRajapinta>();
    */
    
    // uusi Okon/part-a ehdotus:
    public boolean luoViite(String type, String bibtexkey, HashMap fields) {
        Viite viite;
        try {
            // jos viitteen luominen epÃ¤onnistuu nÃ¤yttÃ¤Ã¤ kontrolleri nÃ¤kymÃ¤lle virheen
            viite = new Viite(type, bibtexkey, fields);
        } catch (Exception e) {
            // TODO: kirjaviite voisi antaa lisÃ¤tietoa syÃ¶tteen epÃ¤onnistuessa
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
            // jos viitteen luominen epÃ¤onnistuu nÃ¤yttÃ¤Ã¤ kontrolleri nÃ¤kymÃ¤lle virheen
            viite = new Kirjaviite(reference, author, title, year, booktitle, 
                        publisher, pages, address, volume, number, journal);
        } catch (Exception e) {
            // TODO: kirjaviite voisi antaa lisÃ¤tietoa syÃ¶tteen epÃ¤onnistuessa
            return false;
        }
        return kirjaviitteet.add(viite);
    }

    
    // keskenerÃ¤inen hakutoiminto (palauttaa myÃ¶s viitteen, jos hakusana on kentÃ¤n nimessÃ¤)
    public List<KirjaviiteRajapinta> haeSanalla (String hakusana) {
        List<KirjaviiteRajapinta> hakutulokset = new ArrayList<KirjaviiteRajapinta>();
        for (KirjaviiteRajapinta viite : kirjaviitteet) {
            // TODO: kun viiteluokkaan tehty getFields-metodi tms. niin hakutomintoa tarkennettava
            if (viite.toString().contains(hakusana)) hakutulokset.add(viite);
        }
        return hakutulokset;
    }
    
    // listaa viitteet kÃ¤yttÃ¶liittymÃ¤Ã¤ ja tallennusta varten
    // VANHA VERSIO: public List<KirjaviiteRajapinta> listaaViitteet () {
    public List<KirjaviiteRajapinta> listaaViitteet () {
        return kirjaviitteet;
    }
    
    // palauta viimeksi lisÃ¤tty kirjaviite
    public String haeViimeksiLisattyKirjaviite() {
        if (!kirjaviitteet.isEmpty()) {
            BibtexMuunnos bibtex = new BibtexMuunnos(kirjaviitteet.get(kirjaviitteet.size() - 1));
            return bibtex.muunnaBibtexviitteeksi();
        }
        return null;
    }
    
    // lisÃ¤tÃ¤Ã¤nkÃ¶ metodi viitteiden levytallennusta varten?
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


    
    // metodi luokkien lataamiseen levyltÃ¤
    public List<Kirjaviite> haeViitteet () {
        return null;
    }
}