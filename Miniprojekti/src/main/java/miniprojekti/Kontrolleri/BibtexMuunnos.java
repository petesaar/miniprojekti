package miniprojekti.Kontrolleri;

import java.util.Map;
import java.util.Map.Entry;
import miniprojekti.Viite.Viite;

/**
 * @author Jeesusteippaajat
 *
 * Luokka viiteolioiden muuntamiseksi bibtex-viitteiksi tallennuksen ja
 * käyttöliittymään (esikatselu bibtex-muodossa).
 */
public final class BibtexMuunnos implements Muuntaja {

    /**
     * Muuntaa viiteen BibTeX muotoon, ja kirjoittaa sen annettuun
     * StringBuilderiin.
     *
     * @param viite Muunnettava viite.
     * @param teksti StringBuilder, johon viite kirjoitetaan.
     */
    @Override
    public void muunnaViite(StringBuilder teksti, Viite viite) {
        teksti.append('@').append(viite.getType()).append('{').append(viite.getBibtexkey()).append(",\n");
        Map<String, String> fields = viite.getFields();
        for (Entry<String, String> entry : fields.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                teksti.append(entry.getKey()).append(" = {").append(muunnaStringAakkoset(entry.getValue())).append("},\n");
            }
        }
        teksti.append("}\n");
    }

    /**
     * Muuntaa annetun String olion kirjaimet ä, Ä, ö, Ö, å, Å vastaaviksi latex
     * merkinnöiksi.
     *
     * @param muunnettava Muunnettava String.
     * @return Muunnetun String olion, jossa edellä mainitut kirjaimet ovat
     * muutettu.
     */
    private static String muunnaStringAakkoset(String muunnettava) {
        StringBuilder muunnettu = new StringBuilder();
        for (int i = 0; i < muunnettava.length(); i++) {
            muunnettu.append(muunnaErikoisMerkit(muunnettava.charAt(i)));
        }
        return muunnettu.toString();
    }

    private static String muunnaErikoisMerkit(char merkki) {
        switch (merkki) {
            case 'ä':
                return kaksoispisteet('a');
            case 'Ä':
                return kaksoispisteet('A');
            case 'ö':
                return kaksoispisteet('o');
            case 'Ö':
                return kaksoispisteet('O');
            case 'å':
                return oMerkki('a');
            case 'Å':
                return oMerkki('A');
        }
        return Character.toString(merkki);
    }

    private static String kaksoispisteet(char merkki) {
        return "\\\"{" + merkki + "}";
    }

    private static String oMerkki(char merkki) {
        return "\\r{" + merkki + "}";
    }

    /**
     * Muuntaa yksittäisen viitteen BibTeX muotoon.
     *
     * @param viite Muunnettava viite.
     * @return Annettu viite BibTeX muodossa.
     */
    @Override
    public String muunnaViite(Viite viite) {
        StringBuilder teksti = new StringBuilder();
        muunnaViite(teksti, viite);
        return teksti.toString();
    }
}
