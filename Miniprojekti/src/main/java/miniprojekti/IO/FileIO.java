package miniprojekti.IO;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Jeesusteippaajat
 */
public final class FileIO implements IOOut, Closeable {

    private final OutputStream stream;
    private boolean closed = false;

    public FileIO(String polku) throws IOException {
        if (polku == null) {
            throw new IllegalArgumentException("Polku oli null.");
        }
        File tiedosto = new File(polku);
        luoTyhjaTiedosto(tiedosto);
        stream = new FileOutputStream(tiedosto);
    }

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

    @Override
    protected void finalize() {
        try {
            super.finalize();
            close();
        } catch (Throwable ex) {
        }
    }

    @Override
    public void close() throws IOException {
        if (stream != null && !closed) {
            stream.close();
            closed = true;
        }
    }
}
