package miniprojekti.Viite;

import java.util.ArrayList;

/**
 *
 * @author Jeesusteippaajat
 */
public interface ViiteJoukko {

    Iterable<Viite> getKirjaViitteet();
    
    boolean save(Viite viite);
    
    ArrayList<Viite> getViitteet();
    
    String[] getErrors();
}
