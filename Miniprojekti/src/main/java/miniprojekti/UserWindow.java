package miniprojekti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import miniprojekti.Kontrolleri.Kontrolleri;
/**
 * Luokka toimii käyttöliittymässä runkona eri välilehtien osioille
 *
 * @author Jeesusteippaajat 
 */
public class UserWindow extends JPanel {
    
    static Kontrolleri ohjausOlio = new Kontrolleri();
    public JTabbedPane areena = new JTabbedPane();  //yleinen paneeli, johon muut liitetään
    static JPanel lisaysPaneeli = new JPanel();     //viitteen lisäämiseen
    
    //private BufferedImage taustakuva;    
    
    public UserWindow(){        
       
        //anonyymi sisäluokka, jolla tehdään areenasta transparentti 
        areena.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI(){
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex){}            
        });
        //-------------------------------------------------------------
        
        setLayout(new GridLayout(1, 1));    //areenan muotoiluja      
        add(areena);
                
        areena.addTab("Viitteen lisäys", lisaysPaneeli);
        
        //------------------tehdään paneelit-------------------------------------------
        lisaysPaneeli.setLayout(null);
        lisaysPaneeli.setOpaque(false);
        
        //------------------------------------------------------------------------------
        
        LisaysPaneeli lisaysOlio = new LisaysPaneeli();
        lisaysOlio.piirra();

    }

        
//-----------------------------------------------------------------------------------------------------------------------
    public void paint (Graphics g){
        super.paint(g);
        //setBackground(new Color(0x00,0x00,0x00,255));        
    }
//-------------------------------------------------------------------------------------------------------------------------

}
