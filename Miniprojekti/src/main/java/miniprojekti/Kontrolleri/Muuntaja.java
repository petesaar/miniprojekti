package miniprojekti.Kontrolleri;

import miniprojekti.Viite.KirjaviiteRajapinta;

/**
 * Määrittää viitteen muunnoksen.
 *
 * @author Jeesusteippaajat
 */
public interface Muuntaja {

    /**
     * Muuttaa viitten toteutetulla muuntajalla.
     *
     * @param teksti Kirjoittaa muunnetun viitteen annettuun StringBuidleriin.
     * @param viite Kirjoitettava viite.
     */
    public void muunnaViite(StringBuilder teksti, KirjaviiteRajapinta viite);

    /**
     * Muuttaa viitten toteutetulla muuntajalla.
     *
     * @param viite Muunnettava viite.
     * @return Viite String muodossa.
     */
    public String muunnaViite(KirjaviiteRajapinta viite);
}
