package miniprojekti;

import javax.swing.JFrame;
/**
 * Käynnistys
 *
 * @author Jeesusteippaajat 
 */
public class App extends JFrame{
    
    public App() {        
        add(new UserWindow());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setTitle("Viitteidenkäsittelijä");
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args){        
        new App();
    }
}
