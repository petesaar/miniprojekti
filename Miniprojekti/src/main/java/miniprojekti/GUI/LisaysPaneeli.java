
package miniprojekti.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Jeesusteippaajat
 */
public class LisaysPaneeli {
    
    JButton lisaa = new JButton();    //lisäyspainike
    JLabel otsikko_pakolliset = new JLabel("Pakolliset kentät:");
    JLabel otsikko_vapaavalintaiset = new JLabel("Vapaavalintaiset kentät:");
    JTextPane author_kentta = new JTextPane();
    JTextPane title_kentta = new JTextPane();
    JTextPane year_kentta = new JTextPane();
    JTextPane publisher_kentta = new JTextPane();
    
    public void piirra(){        
        
        lisaa.setBounds(40,630,120,40); 
        lisaa.setText("Lisää viite");
        lisaa.setFont(new Font("Arial", Font.BOLD, 14));
        lisaa.setBackground(Color.CYAN);
        
        otsikko_pakolliset.setBounds(40,40,200,40);         
        otsikko_pakolliset.setFont(new Font("Arial", Font.BOLD, 16));
        otsikko_pakolliset.setForeground(Color.BLUE);
        
        otsikko_vapaavalintaiset.setBounds(440,40,200,40);         
        otsikko_vapaavalintaiset.setFont(new Font("Arial", Font.BOLD, 16));
        otsikko_vapaavalintaiset.setForeground(Color.BLUE);
        
        author_kentta.setBounds(40,100,300,30);                  
        author_kentta.setBackground(new Color(0xaa,0xab,0xcf));
        author_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        author_kentta.setForeground(Color.black);
        author_kentta.setText("Authors");
    
        title_kentta.setBounds(40,150,300,30);                  
        title_kentta.setBackground(new Color(0xaa,0xab,0xcf));
        title_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        title_kentta.setForeground(Color.black);
        title_kentta.setText("Title");        
        
        year_kentta.setBounds(40,200,300,30);                  
        year_kentta.setBackground(new Color(0xaa,0xab,0xcf));
        year_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        year_kentta.setForeground(Color.black);
        year_kentta.setText("Year");        
        
        publisher_kentta.setBounds(40,250,300,30);                  
        publisher_kentta.setBackground(new Color(0xaa,0xab,0xcf));
        publisher_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        publisher_kentta.setForeground(Color.black);
        publisher_kentta.setText("Publisher");        
        
        UserWindow.lisaysPaneeli.add(lisaa);         //lisäyspainike
        UserWindow.lisaysPaneeli.add(otsikko_pakolliset);
        UserWindow.lisaysPaneeli.add(otsikko_vapaavalintaiset);
        UserWindow.lisaysPaneeli.add(author_kentta);
        UserWindow.lisaysPaneeli.add(title_kentta);
        UserWindow.lisaysPaneeli.add(year_kentta);
        UserWindow.lisaysPaneeli.add(publisher_kentta);
        
        //-----------------------lisäyspainike----------------------------------
        lisaa.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {  
                //tähän painikkeen toimintakoodi
            }
        });
    }
    
}
