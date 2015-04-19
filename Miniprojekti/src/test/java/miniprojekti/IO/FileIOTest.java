package miniprojekti.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * @author Jeesusteippaajat
 */
public final class FileIOTest {

    @Test
    public void testNullArgumentPolku() {
        FileIO io = null;
        try {
            io = new FileIO(null);
            fail("Null argumentti läpäisi.");
        } catch (IOException ex) {
            fail();
        } catch (IllegalArgumentException ex) {
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Test
    public void tyhjanTiedostonLuontiOnnistuu() {
        FileIO io = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            if (!sattumanvarainenTiedosto.delete()) {
                fail("Ei pysty poistamaan edellistä");
            }
            io = new FileIO(polku);
            File created = new File(polku);
            assertTrue(created.exists());
        } catch (IOException ex) {
            fail();
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Test
    public void tyhjanTiedostonLuontiOnnistuuVaikkaOlisiOlemassa() {
        FileIO io = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            io = new FileIO(polku);
            File created = new File(polku);
            assertTrue(created.exists());
        } catch (IOException ex) {
            fail();
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Test
    public void tiedostonStreamEiOleNull() {
        FileIO io = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".Jeesus");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            io = new FileIO(polku);
            assertNotNull(io.getOutputStream());
        } catch (IOException ex) {
            fail();
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Test
    public void tiedostoonKirjoitusOnnistuu() {
        OutputStreamWriter streamiinKirjoittaja = null;
        InputStream streamSisaan = null;
        InputStreamReader streaminLukija = null;
        FileIO io = null;
        Scanner lukija = null;
        try {
            File sattumanvarainenTiedosto = File.createTempFile("testMini", ".txt");
            String polku = sattumanvarainenTiedosto.getAbsolutePath();
            io = new FileIO(polku);
            streamiinKirjoittaja = new OutputStreamWriter(io.getOutputStream(), MuuntavaTallentaja.CHARSET);
            String expected = "testia34äå43lpå2";
            streamiinKirjoittaja.write(expected);
            streamiinKirjoittaja.close();
            streamSisaan = new FileInputStream(sattumanvarainenTiedosto);
            streaminLukija = new InputStreamReader(streamSisaan, MuuntavaTallentaja.CHARSET);
            lukija = new Scanner(streaminLukija);
            assertEquals(expected, lukija.nextLine());
        } catch (IOException ex) {
            fail();
        } finally {
            if (streamiinKirjoittaja != null) {
                try {
                    streamiinKirjoittaja.close();
                } catch (IOException ex) {
                }
            }
            if (io != null) {
                try {
                    io.close();
                } catch (IOException ex) {
                }
            }
            if (lukija != null) {
                lukija.close();
            }
            if (streaminLukija != null) {
                try {
                    streaminLukija.close();
                } catch (IOException ex) {
                }
            }
            if (streamSisaan != null) {
                try {
                    streamSisaan.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
