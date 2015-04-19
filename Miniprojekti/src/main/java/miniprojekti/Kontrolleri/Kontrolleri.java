package miniprojekti.Kontrolleri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import miniprojekti.IO.FileIO;
import miniprojekti.IO.MuuntavaTallentaja;
import miniprojekti.IO.StreamKirjoittaja;
import miniprojekti.Viite.Artikkeliviite;
import miniprojekti.Viite.Inproceedings;
import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;

/**
 * Luokasta tehdÃ¤Ã¤n ohjausolio, joka toimii yhteistyÃ¶ssÃ¤ muiden luokkien
 * kanssa
 *
 * @author Jeesusteippaajat
 */
public class Kontrolleri {

    // 
    private final ViiteJoukko kirjaviitteet = new ViitejoukkoImpl();
    private final Muuntaja bibtexMuuntaja = new BibtexMuunnos();
    private final StreamKirjoittaja tallentaja = new MuuntavaTallentaja(kirjaviitteet, bibtexMuuntaja);


    public boolean luoViite(String tyyppi, String reference, Map<String, String> kentat) {
        if (tyyppi.equals("book")) {
            return kirjaviitteet.save(new Kirjaviite(reference, kentat.get("author"), kentat.get("title"), kentat.get("year"), 
                    kentat.get("publisher"), kentat.get("booktitle"), kentat.get("pages"), kentat.get("address"), kentat.get("number"), 
                    kentat.get("volume"), kentat.get("journal")));
        } else if (tyyppi.equals("article")) {
            return kirjaviitteet.save(new Artikkeliviite(reference, kentat.get("author"), kentat.get("title"), kentat.get("journal"), 
                    kentat.get("year"), kentat.get("volume"), kentat.get("number"), kentat.get("pages"), kentat.get("month"), 
                    kentat.get("note"), kentat.get("key")));
        } else if (tyyppi.equals("inproceedings")) {
            return kirjaviitteet.save(new Inproceedings(reference, kentat.get("author"), kentat.get("title"), kentat.get("year"), 
                    kentat.get("booktitle"), kentat.get("editor"), kentat.get("volume"), kentat.get("series"), kentat.get("pages"), 
                    kentat.get("address"), kentat.get("month"), kentat.get("orgnanisation"), kentat.get("publisher"), kentat.get("note"), 
                    kentat.get("key")));
        }
        return false;
    }
    
    public String[] getErrors() {
        return kirjaviitteet.getErrors();
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
    public List<Viite> haeSanalla(String hakusana) {
        List<Viite> hakutulokset = new ArrayList<Viite>();
        for (Viite viite : kirjaviitteet.getViitteet()) {
            // TODO: kun viiteluokkaan tehty getFields-metodi tms. niin hakutomintoa tarkennettava
            if (viite.toString().contains(hakusana)) {
                hakutulokset.add(viite);
            }
        }
        return hakutulokset;
    }

    // listaa viitteet kÃ¤yttÃ¶liittymÃ¤Ã¤ ja tallennusta varten
    // VANHA VERSIO: public List<KirjaviiteRajapinta> listaaViitteet () {
    public List<Viite> listaaViitteet() {
        return kirjaviitteet.getViitteet();
    }

    // palauta viimeksi lisÃ¤tty kirjaviite
    public String haeViimeksiLisattyKirjaviite() {
        if (!kirjaviitteet.getViitteet().isEmpty()) {
            return bibtexMuuntaja.muunnaViite(kirjaviitteet.getViitteet().get(kirjaviitteet.getViitteet().size() - 1));
        }
        return null;
    }

    // lisÃ¤tÃ¤Ã¤nkÃ¶ metodi viitteiden levytallennusta varten?
    public void tallennaViitteet() {
        FileIO io = null;
        try {
            io = new FileIO("target" + File.separatorChar + "tallennukset.bib");
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
    public List<Kirjaviite> haeViitteet() {
        return null;
    }
}
