package miniprojekti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import miniprojekti.Kontrolleri.Kontrolleri;
/**
 * Käynnistys
 *
 * @author Jeesusteippaajat 
 */
public class App extends JFrame{
    
    public App() {        
        add(new UserWindow());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 750);
        setLocationRelativeTo(null);
        setTitle("Viitteidenkäsittelijä v1.0");
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args){
        // käyttöliittymän käynnistys event dispatch threadissa
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
