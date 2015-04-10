package miniprojekti.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Jeesusteippaajat
 */
public final class FileIOTest {

    @Test
    public void testNullArgumentPolku() {
        try {
            new FileIO(null);
            fail("Null argumentti läpäisi.");
        } catch (IOException ex) {
            fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void tyhjanTiedostonLuontiOnnistuu() {
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            if (!sattumanvarainenTiedosto.delete()) {
                fail("Ei pysty poistamaan edellistä");
            }
            FileIO io = new FileIO(polku);
            File created = new File(polku);
            assertTrue(created.exists());
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void tyhjanTiedostonLuontiOnnistuuVaikkaOlisiOlemassa() {
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            FileIO io = new FileIO(polku);
            File created = new File(polku);
            assertTrue(created.exists());
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void tyhjanTiedostonLuontiLukossaEiOnnistu() {
        FileInputStream in = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            in = new FileInputStream(sattumanvarainenTiedosto);
            FileIO io = new FileIO(polku);
            fail("Lukkiutuminen ei aiheuta virhettä");
        } catch (IOException ex) {
            fail();
        } catch (IllegalArgumentException ex) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Test
    public void huonoPolkuErroria() {
        try {
            File sattumanvarainenTiedosto = new File("Ö:/");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            FileIO io = new FileIO(polku);
            fail("Huono polku ei aiheuta virhettä");
        } catch (IOException ex) {
            fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void tiedostonStreamEiOleNull() {
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            FileIO io = new FileIO(polku);
            assertNotNull(io.getOutputStream());
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void tiedostoonKirjoitusOnnistuu() {
        OutputStreamWriter streamiinKirjoittaja = null;
        FileIO io = null;
        Scanner lukija = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".txt");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            io = new FileIO(polku);
            streamiinKirjoittaja = new OutputStreamWriter(io.getOutputStream());
            String expected = "testia34äå43lpå2";
            streamiinKirjoittaja.write(expected);
            streamiinKirjoittaja.close();
            lukija = new Scanner(sattumanvarainenTiedosto);
            assertEquals(expected, lukija.nextLine());
        } catch (IOException ex) {
            fail();
        } finally {
            try {
                if (streamiinKirjoittaja != null) {
                    streamiinKirjoittaja.close();
                }
                if (io != null) {
                    io.close();
                }
                if (lukija != null) {
                    lukija.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}
