package miniprojekti.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.ViiteJoukko;

/**
 * @author Jeesusteippaajat
 *
 * Tallentaa ViiteJoukon viitteet BibTeX muodossa annettuun streamiin.
 */
public final class BibtexTallentaja {

    public static final Charset CHARSET = Charset.forName("UTF-8");
    private final ViiteJoukko viitteet;

    /**
     * Luo uuden instannsin BibTeX tallentajasta. Lukee annetusta VitteJoukosta
     * viitteet tallennuksen yhteydessä.
     *
     * @param viitteet ViiteJoukko, jossa ovat tallennettavaksi tarkoitetut
     * viiteet.
     * @throws IllegalArgumentException Jos ViiteJoukko on null.
     */
    public BibtexTallentaja(ViiteJoukko viitteet) {
        if (viitteet == null) {
            throw new IllegalArgumentException("Vitteet oli null.");
        }
        this.viitteet = viitteet;
    }

    /**
     * Tallentaa konstruktorissa annetun ViiteJoukon viitteet annettuun
     * streamiin.
     *
     * @param io Streami, johon viitteet tallennetaan.
     * @throws IOException Kun kirjoituksessa tulee virhe.
     * @throws IllegalArgumentException Jos annettus streami on null, tai jos
     * ViiteJoukko palauttaa null arvoisen iteroitavan olion.
     */
    public void tallennaStream(IOOut io) throws IOException {
        if (io == null) {
            throw new IllegalArgumentException("IOOut oli null.");
        }
        Iterable<KirjaviiteRajapinta> viiteIteraatio = viitteet.getKirjaViitteet();
        if (viiteIteraatio == null) {
            throw new IllegalArgumentException("Viiteiteraatio oli null.");
        }
        OutputStreamWriter streamiinKirjoittaja = null;
        BufferedWriter tekstinKirjoittaja = null;
        try {
            streamiinKirjoittaja = new OutputStreamWriter(io.getOutputStream(), CHARSET);
            tekstinKirjoittaja = new BufferedWriter(streamiinKirjoittaja);
            tallennaTiedot(viiteIteraatio, tekstinKirjoittaja);
        } finally {
            if (tekstinKirjoittaja != null) {
                tekstinKirjoittaja.close();
            }
            if (streamiinKirjoittaja != null) {
                streamiinKirjoittaja.close();
            }
        }
    }

    /**
     * Suorittaa tallennuksen annettuun BufferedWriteriin.
     *
     * @param viitteet Tallennettavien viitteiden joukko.
     * @param writer BufferedWriter olioon viitteet kirjoitetaan.
     * @throws IOException Kirjoitus virheen sattuessa.
     */
    private void tallennaTiedot(Iterable<KirjaviiteRajapinta> viitteet, BufferedWriter writer) throws IOException {
        for (KirjaviiteRajapinta viite : viitteet) {
            StringBuilder teksti = new StringBuilder();
            teksti.append("@book{");
            teksti.append(viite.getRefrence());
            teksti.append(",\nauthor = {");
            teksti.append(viite.getAuthor());
            teksti.append("},\ntitle = {");
            teksti.append(viite.getTitle());
            teksti.append("},\nyear = {");
            teksti.append(viite.getYear());
            teksti.append("},\npublisher = {");
            teksti.append(viite.getPublisher());
            teksti.append("},\n}\n");
            writer.write(teksti.toString());
        }
    }
}
