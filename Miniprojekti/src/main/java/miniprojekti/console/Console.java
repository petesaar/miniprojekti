
package miniprojekti.console;

import java.util.HashMap;
import java.util.Map;
import miniprojekti.Kontrolleri.Kontrolleri;
import miniprojekti.Viite.Viite;

/**
 *
 * @author Jeesusteippaajat
 * 
 * Luokka viitteidenkäsittelijän ajamiseen komentoriviltä
 */
public class Console {
    
    private IO io;
    private Kontrolleri kontrolleri;

    public Console(IO io, Kontrolleri kontrolleri) {
        this.io = io;
        this.kontrolleri = kontrolleri;
    }
    
    /*
     * book: luo uuden kirjaviitteen
     * article: luo uuden artikkeliviitteen
     * inproceedings: luo uuden inproceedings-viitteen
     * list: tulostaa kirjaviitteet
     * quit: lopettaa suorituksen
     */
    public void run() {
        while (true) {
            String input = io.readLine("> ");
            if (input.equals("quit")) {
                break;
            } else if (input.equals("book")) {
                luoKirjaViite();
            } else if (input.equals("article")) {
                luoArticleViite();
            } else if (input.equals("inproceedings")) {
                luoInproceedingsViite();
            } else if (input.equals("list")) {
                haeViitteet();
            } else if (input.equals("save")) {
                tallennaViitteet();
            } else if (input.equals("bibtex")) {
                tulostaBibtexMuodossa();
            } else if (input.contains("delete")) {
                deletoi("Poista "+input.substring(7));
            }
        }
    }
    
    private Map<String, String> yhteisetAttribuutit() {
        Map<String, String> attrs = new HashMap<String, String>();
        attrs.put("reference", io.readLine("reference: "));
        attrs.put("author", io.readLine("author: "));
        attrs.put("title", io.readLine("title: "));
        attrs.put("year", io.readLine("year: "));
        return attrs;
    }

    private void luoKirjaViite() {
        Map<String, String> attrs = yhteisetAttribuutit();
        attrs.put("publisher", io.readLine("publisher: "));
        attrs.put("address", io.readLine("address: "));
        attrs.put("volume", io.readLine("volume: "));
        attrs.put("number", io.readLine("number: "));
        if (kontrolleri.luoViite("book", attrs.get("reference"), attrs)) {
            io.print("Viite lisattiin onnistuneesti\n");
        } else {
            tulostaVirheet();
        }
    }
    
    private void luoArticleViite() {
        Map<String, String> attrs = yhteisetAttribuutit();
        attrs.put("volume", io.readLine("volume: "));
        attrs.put("journal", io.readLine("journal: "));
        attrs.put("pages", io.readLine("pages: "));
        attrs.put("number", io.readLine("number: "));
        if (kontrolleri.luoViite("article", attrs.get("reference"), attrs)) {
            io.print("Viite lisattiin onnistuneesti\n");
        } else {
            tulostaVirheet();
        }
    }

    private void luoInproceedingsViite() {
        Map<String, String> attrs = yhteisetAttribuutit();
        attrs.put("booktitle", io.readLine("booktitle: "));
        attrs.put("publisher", io.readLine("publisher: "));
        attrs.put("pages", io.readLine("pages: "));
        attrs.put("address", io.readLine("address: "));
        attrs.put("volume", io.readLine("volume: "));
        attrs.put("number", io.readLine("number: "));
        if (kontrolleri.luoViite("inproceedings", attrs.get("reference"), attrs)) {
            io.print("Viite lisattiin onnistuneesti\n");
        } else {
            tulostaVirheet();
        }
    }
    
    private void tulostaVirheet() {
        for (String error : kontrolleri.getErrors()) {
            io.print(error + "\n");
        }
    }
    
    private void haeViitteet() {
        for (Viite viite : kontrolleri.listaaViitteet()) {
            io.print(viite.toString() + "\n");
        }
    }

    private void tallennaViitteet() {
        if (kontrolleri.tallennaViitteet()) {
            io.print("Viitteiden tallennus onnistui");
        } else {
            io.print("Viitteiden tallennus ei onnistunut");
        }
    }
    
    private void deletoi(String indeksi) {
        kontrolleri.poistaViite(indeksi); 
    }

    private void tulostaBibtexMuodossa() {
        io.print(kontrolleri.haeViimeksiLisattyKirjaviite());
    }

}
