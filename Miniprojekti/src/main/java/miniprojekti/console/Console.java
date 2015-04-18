
package miniprojekti.console;

import miniprojekti.Kontrolleri.Kontrolleri;
import miniprojekti.Viite.Kirjaviite;
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
    
    /* Komentorivin testaamiseen
    public static void main(String[] args) {
        new Console(new ConsoleIO(), new Kontrolleri()).run();
    }
    */
    
    /*
     * Nykyiset komennot:
     * 
     * -- newbook: luo uuden kirjaviitteen
     * -- listbooks: tulostaa kirjaviitteet
     * -- tyhjä syöte: lopettaa suorituksen
     */
    public void run() {
        while (true) {
            String input = io.readLine("> ");
            if (input.isEmpty()) {
                break;
            } else if (input.equals("newbook")) {
                luoKirjaviite();
            } else if (input.equals("listbooks")) {
                haeKirjaviitteet();
            }
        }
    }

    private void luoKirjaviite() {
        String reference = io.readLine("reference: ");
        String author = io.readLine("author: ");
        String title = io.readLine("title: ");
        String year = io.readLine("year: ");
        String publisher = io.readLine("publisher: ");
        String booktitle = io.readLine("booktitle: ");
        String pages = io.readLine("pages: ");
        String address = io.readLine("address: ");
        String volume = io.readLine("volume: ");
        String number = io.readLine("number: ");
        String journal  = io.readLine("journal: ");
        if (kontrolleri.luoKirjaviite(reference, author, title, year, publisher, booktitle, 
                                       pages, address, volume, number, journal)) {
            io.print("Viite lisättiin onnistuneesti.\n");
        } else {
            io.print("Viitteen lisäys epäonnistui.\n");
        }
    }
    
    private void haeKirjaviitteet() {
        for (Viite viite : kontrolleri.listaaViitteet()) {
            io.print(viite.toString() + "\n");
        }
    }
    
}
