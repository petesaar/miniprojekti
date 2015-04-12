package miniprojekti.IO;

import java.io.Closeable;
import java.io.OutputStream;

/**
 * @author Jeesusteippaajat
 *
 * Antaa kirjoitus streamin tallennusta varten. Voi olla esimerkiksi tiedosto
 * tai konsoli.
 */
public interface IOOut extends Closeable {

    /**
     * @return Olion streami, johon halutaan kirjotuksen tapahtuvan.
     */
    OutputStream getOutputStream();
}
