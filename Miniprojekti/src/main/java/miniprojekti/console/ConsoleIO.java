
package miniprojekti.console;

import java.util.Scanner;

/**
 *
 * @author Jeesusteippaajat
 */
public class ConsoleIO implements IO {

    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String print) {
        System.out.print(print);
    }

    @Override
    public String readLine(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }
    
}
