package miniprojekti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import miniprojekti.Viite.KirjaviiteRajapinta;

/**
 *
 * @author Jeesusteippaajat
 */
public class ListausPaneeli {
 
    JButton tallenna = new JButton();
    JButton katsele = new JButton();                    //katso tallennetut viitteet
    JTextPane lukualue = new JTextPane();           //tekstialue viitteille
    JScrollPane luku = new JScrollPane(lukualue);    //scrollaava tekstialue

    public void piirra() {

        katsele.setBounds(640, 20, 180, 40);
        katsele.setText("Päivitä luettelo");
        katsele.setFont(new Font("Arial", Font.BOLD, 14));
        katsele.setBackground(Color.green);
        
        tallenna.setBounds(640, 100, 180, 40);
        tallenna.setText("Tallenna levylle");
        tallenna.setFont(new Font("Arial", Font.BOLD, 14));
        tallenna.setBackground(Color.green);
        
        
        luku.setBounds(20, 20, 550, 650);
        luku.setFont(new Font("Arial", Font.BOLD, 13));
        luku.setForeground(Color.black);
        
        lukualue.setBounds(20, 20, 550, 650);
        lukualue.setFont(new Font("Arial", Font.BOLD, 13));
        lukualue.setForeground(Color.black);
        lukualue.setText("Lukualue");
        
        UserWindow.listausPaneeli.add(katsele);        
        UserWindow.listausPaneeli.add(luku); 
        UserWindow.listausPaneeli.add(tallenna); 
        
        //-----------------------kuuntelija katselupainikkeelle----------------------------------
        katsele.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (KirjaviiteRajapinta viite : UserWindow.ohjausOlio.listaaViitteet()) {
                    sb.append(viite.toString()).append("\n");
                }
                lukualue.setText(sb.toString());
            }
        });        

        tallenna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserWindow.ohjausOlio.tallennaViitteet();
            }
        });
    }

}
