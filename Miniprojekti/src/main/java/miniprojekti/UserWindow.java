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
    static JTabbedPane areena = new JTabbedPane();  //yleinen paneeli, johon muut liitetään
    static JPanel lisaysPaneeli = new JPanel();     //paneeli viitteen lisäämiseen
    static JPanel listausPaneeli = new JPanel();     //paneeli, jossa voi katsoa kaikkia viitteitä
    static JPanel muokkausPaneeli = new JPanel();     //paneeli, jossa voi käsitellä viitteitä
    
    //private BufferedImage taustakuva;    
    
    public UserWindow(){        
       
        //anonyymi sisäluokka, jolla tehdään areenasta transparentti 
        areena.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI(){
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex){}            
        });
        //-------------------------------------------------------------
        
        setLayout(new GridLayout(1, 1));    //areenan muotoiluja      
        add(areena);
          
        areena.addTab("     Käsittele viitteitä     ", listausPaneeli);
        areena.addTab("     Lisää uusi viite     ", lisaysPaneeli);
        
        
        //areena.addTab("Muokkaa viitteitä", muokkausPaneeli);
        
        //------------------tehdään paneelit-------------------------------------------
        lisaysPaneeli.setLayout(null);
        lisaysPaneeli.setOpaque(false);
        listausPaneeli.setLayout(null);
        listausPaneeli.setOpaque(false);
        muokkausPaneeli.setLayout(null);
        muokkausPaneeli.setOpaque(false);
        
        //------------------------------------------------------------------------------
        
        LisaysPaneeli lisaysOlio = new LisaysPaneeli();
        lisaysOlio.piirra();
        ListausPaneeli listausOlio = new ListausPaneeli();
        listausOlio.piirra();
        MuokkausPaneeli muokkausOlio = new MuokkausPaneeli();
        muokkausOlio.piirra();
    }

        
//-----------------------------------------------------------------------------------------------------------------------
    public void paint (Graphics g){
        super.paint(g);
        //setBackground(new Color(0x00,0x00,0x00,255));        
    }
//-------------------------------------------------------------------------------------------------------------------------

}
