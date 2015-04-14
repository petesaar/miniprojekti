package miniprojekti.Viite;

import java.util.ArrayList;

/**
 *
 * @author Jeesusteippaajat
 */
public interface ViiteJoukko {

    Iterable<KirjaviiteRajapinta> getKirjaViitteet();
    
    boolean save(KirjaviiteRajapinta viite);
    
    ArrayList<KirjaviiteRajapinta> getViitteet();
    
    String[] getErrors();
}
