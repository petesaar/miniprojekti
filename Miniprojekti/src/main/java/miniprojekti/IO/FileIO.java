package miniprojekti.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Jeesusteippaajat
 *
 * Tarjoaa streamin tiedostoon kirjoitusta varten.
 */
public final class FileIO implements IOOut {

    private final OutputStream stream;
    private boolean closed = false;

    /**
     * Luo uuden streamin tiedostoon. Edellinen, samanniminen tiedosto
     * poistetaan jos se on olemassa.
     *
     * @param polku Tiedosto polku, johon tiedosto luodaan ja streami avataan.
     * @throws IOException Kun streamin avauksessa tulee virhe.
     * @throws IllegalArgumentException Kun polku on null, tiedostoa polussa on
     * tiedosto jota ei voida poistaa, tai polkuun ei voida luoda uutta
     * tiedostoa.
     */
    public FileIO(String polku) throws IOException {
        if (polku == null) {
            throw new IllegalArgumentException("Polku oli null.");
        }
        File tiedosto = new File(polku);
        luoTyhjaTiedosto(tiedosto);
        System.out.println(tiedosto.getAbsolutePath());
        stream = new FileOutputStream(tiedosto);
    }

    /**
     * Poistaa vanhan tiedoston jos olemassa ja luo uuden.
     *
     * @param tiedosto Joka poistetaan ja luodaan.
     */
    private void luoTyhjaTiedosto(File tiedosto) {
        if (tiedosto.exists()) {
            if (!tiedosto.delete()) {
                throw new IllegalArgumentException("Edellistä tiedostoa ei voida korvata.");
            }
        }
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Tiedostoa ei voida luoda polkuun: " + tiedosto.getAbsolutePath() + "\n" + ex.toString());
        }
    }

    @Override
    public OutputStream getOutputStream() {
        return stream;
    }

    /**
     * Sulkee streamin, jos ei ole jo suljettu.
     */
    @Override
    protected void finalize() {
        try {
            super.finalize();
            close();
        } catch (Throwable ex) {
        }
    }

    /**
     * Sulkee avatun streamin.
     *
     * @throws IOException Kun sulkemisessa tulee virhe.
     */
    @Override
    public void close() throws IOException {
        if (stream != null && !closed) {
            stream.close();
            closed = true;
        }
    }
}
