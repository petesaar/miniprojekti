package miniprojekti.IO;

import java.io.IOException;

/**
 * @author Jeesusteippaajat
 *
 * Suorittaa streamiin kirjoituksen.
 */
public interface StreamKirjoittaja {

    /**
     * Suorittaa toteutetun kirjoituksen annettuun streamiin.
     *
     * @param io Streami johon kirjoitus tehdään.
     * @throws IOException Jos kijrjoituksessa esiintyy virhe.
     */
    public void tallennaStream(IOOut io) throws IOException;
}
