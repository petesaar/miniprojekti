package miniprojekti.Kontrolleri;

import java.util.Map;
import miniprojekti.Viite.KirjaviiteRajapinta;

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
    public void muunnaViite(StringBuilder teksti, KirjaviiteRajapinta viite) {
        teksti.append("@").append(viite.getType()).append("{").append(viite.getBibtexkey()).append(",\n");
        Map<String, String> fields = viite.getFields();
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                teksti.append(entry.getKey()).append(" = {").append(entry.getValue()).append("},\n");
            }
        }
        teksti.append("}\n");
    }

    /**
     * Muuntaa yksittäisen viitteen BibTeX muotoon.
     *
     * @param viite Muunnettava viite.
     * @return Annettu viite BibTeX muodossa.
     */
    @Override
    public String muunnaViite(KirjaviiteRajapinta viite) {
        StringBuilder teksti = new StringBuilder();
        muunnaViite(teksti, viite);
        return teksti.toString();
    }
}
