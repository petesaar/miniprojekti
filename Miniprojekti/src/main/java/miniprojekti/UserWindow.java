package miniprojekti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.net.*;
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
    JLabel tab0 = new JLabel();
    JLabel tab1 = new JLabel();

    private BufferedImage taustakuva;    
    
    public UserWindow() { 
        
        try{
            taustakuva = ImageIO.read(getClass().getClassLoader().getResource("kirjasto_2.png")); 
        }catch(Exception e){               
        }
        
        //anonyymi sisäluokka, jolla tehdään areenasta transparentti 
        areena.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            }
        });
        //-------------------------------------------------------------
        tab0.setPreferredSize(new Dimension(270, 40));
        tab0.setText("        Käsittele viitteitä     ");
        tab0.setBackground(new Color(205,133,63));
        tab0.setFont(new Font("Verdana", Font.BOLD, 16));
        
        tab1.setPreferredSize(new Dimension(270, 40));
        tab1.setText("           Lisää uusi viite     ");
        tab1.setBackground(new Color(205,133,63));
        tab1.setFont(new Font("Verdana", Font.BOLD, 16));
        
        setLayout(new GridLayout(1, 1));    //areenan muotoiluja      
        add(areena);        
        
        areena.addTab("     Käsittele viitteitä     ", listausPaneeli);
        areena.addTab("     Lisää uusi viite     ", lisaysPaneeli);        
        areena.setBackground(new Color(156,196,222));
        
        areena.setTabComponentAt(0, tab0);
        areena.setTabComponentAt(1, tab1);
        
        //------------------tehdään paneelit-------------------------------------------
        lisaysPaneeli.setLayout(null);
        lisaysPaneeli.setOpaque(false);
        listausPaneeli.setLayout(null);
        listausPaneeli.setOpaque(false);        

        //------------------------------------------------------------------------------
        LisaysPaneeli lisaysOlio = new LisaysPaneeli();
        lisaysOlio.piirra();
        ListausPaneeli listausOlio = new ListausPaneeli();
        listausOlio.piirra();        
        
        areena.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            //System.out.println("Tab: " + areena.getSelectedIndex());
            ListausPaneeli.paivita.doClick();
        }
    });

    }

//-----------------------------------------------------------------------------------------------------------------------
    public void paint(Graphics g) {
        super.paint(g);        
    }
//-------------------------------------------------------------------------------------------------------------------------
        public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        g.drawImage(taustakuva, 0, 0, 850, 750, this);        
    }
}
