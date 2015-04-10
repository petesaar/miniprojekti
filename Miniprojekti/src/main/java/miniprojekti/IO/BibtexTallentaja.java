package miniprojekti.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.ViiteJoukko;

/**
 * @author Jeesusteippaajat
 */
public final class BibtexTallentaja {

    private final ViiteJoukko viitteet;

    public BibtexTallentaja(ViiteJoukko viitteet) {
        if (viitteet == null) {
            throw new IllegalArgumentException("Vitteet oli null.");
        }
        this.viitteet = viitteet;
    }

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
            streamiinKirjoittaja = new OutputStreamWriter(io.getOutputStream());
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
