
package miniprojekti.console;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeesusteippaajat
 * 
 * EasyB testejä varten luotu stubi
 */
public class StubIO implements IO {

    private String[] lines;
    private List<String> prints;
    private int index;

    public StubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<String>();
    }

    @Override
    public void print(String print) {
        prints.add(print);
    }

    public List<String> getPrints() {
        return prints;
    }

    @Override
    public String readLine(String prompt) {
        print(prompt);
        if (index < lines.length) {
            return lines[index++];
        }
        return "";
    }
    
}
