package miniprojekti.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Objects;
import miniprojekti.Kontrolleri.Muuntaja;
import miniprojekti.Viite.KirjaviiteRajapinta;
import miniprojekti.Viite.ViiteJoukko;

/**
 * @author Jeesusteippaajat
 *
 * Tallentaa ViiteJoukon viitteet muuntajan muodossa annettuun streamiin.
 */
public final class MuuntavaTallentaja implements StreamKirjoittaja {

    public static final Charset CHARSET = Charset.forName("UTF-8");
    private final ViiteJoukko viitteet;
    private final Muuntaja muuntaja;

    /**
     * Luo uuden instannsin muuntavasta tallentajasta. Lukee annetusta
     * VitteJoukosta viitteet tallennuksen yhteydessä.
     *
     * @param viitteet ViiteJoukko, jossa ovat tallennettavaksi tarkoitetut
     * viiteet.
     * @param muuntaja Muunnoksessa käytettävä muuntaja.
     * @throws IllegalArgumentException Jos ViiteJoukko on null.
     */
    public MuuntavaTallentaja(ViiteJoukko viitteet, Muuntaja muuntaja) {
        if (Objects.isNull(viitteet)) {
            throw new IllegalArgumentException("Vitteet oli null.");
        }
        if (Objects.isNull(muuntaja)) {
            throw new IllegalArgumentException("Muuntaja oli null.");
        }
        this.viitteet = viitteet;
        this.muuntaja = muuntaja;
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
    @Override
    public void tallennaStream(IOOut io) throws IOException {
        if (Objects.isNull(io)) {
            throw new IllegalArgumentException("IOOut oli null.");
        }
        Iterable<KirjaviiteRajapinta> viiteIteraatio = viitteet.getKirjaViitteet();
        if (Objects.isNull(viiteIteraatio)) {
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
        StringBuilder teksti = new StringBuilder();
        for (KirjaviiteRajapinta viite : viitteet) {
            muuntaja.muunnaViite(teksti, viite);
        }
        writer.append(teksti);
    }
}