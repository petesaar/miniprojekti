package miniprojekti.Viite;

import miniprojekti.Viite.validaattorit.Validator;

/**
 *
 * @author Jeesusteippaajat
 */
public interface KirjaviiteRajapinta {

    String getRefrence();

    String getAuthor();

    String getYear();

    String getTitle();

    String getPublisher();
    
    Validator getValidator();
}
