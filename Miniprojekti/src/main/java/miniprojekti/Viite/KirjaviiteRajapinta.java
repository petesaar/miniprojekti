package miniprojekti.Viite;

import java.util.Map;
import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public interface KirjaviiteRajapinta {

    String getRefrence();
    
    String getBibtexkey();

    String getAuthor();

    String getYear();

    String getTitle();

    String getPublisher();
    
    Validator getValidator();
    
    String getType();
    
    Map<String, String> getFields();
}
