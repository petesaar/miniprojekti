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
    private String virheilmoitus;

    public boolean luoViite(String tyyppi, String reference, Map<String, String> kentat) {
        boolean unique = onkoBibtexkeyOlemassa(reference);
        if (!unique) {
            virheilmoitus = "BibTexKey on jo käytössä.";
            return false;
        }
        virheilmoitus = "";
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
    
    public List<String> getErrors() {
        List<String> virheilmoitukset = new ArrayList();
        if (virheilmoitus.length() > 0) virheilmoitukset.add(virheilmoitus);
        for(String teksti: kirjaviitteet.getErrors()) {
            virheilmoitukset.add(teksti);
        }
        
        return virheilmoitukset;
    }

    public boolean onkoBibtexkeyOlemassa (String bibtexkey) {
        for (Viite viite : kirjaviitteet.getViitteet()) {
            if (viite.getBibtexkey().equals(bibtexkey)) {           
                return false;              
            }
        }
        return true;
    }
    
    /* keskeneräinen toiminto, joka poistaa yksittäisen viitteen
    public poistaViite(String indeksi) {
        kirjaviitteet.remove(indeksi);
    }
    */

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
    public boolean tallennaViitteet() {
        FileIO io = null;
        try {
            io = new FileIO("tallennukset.bib");
            tallentaja.tallennaStream(io);
            return true;
        } catch (IOException ex) {
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
        return false;
    }

    // metodi luokkien lataamiseen levyltÃ¤
    public List<Kirjaviite> haeViitteet() {
        return null;
    }
}
