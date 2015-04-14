package miniprojekti;

import java.awt.Font;
import javax.swing.*;
import java.util.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import miniprojekti.Viite.KirjaviiteRajapinta;

/**
 *
 * @author Jeesusteippaajat
 */
public class MuokkausPaneeli {

    JButton paivita = new JButton();                    //päivitä viiteluettelo
    JTextPane lukualue = new JTextPane();           //tekstialue viitteille
    JScrollPane luku = new JScrollPane(lukualue);    //scrollaava tekstialue

    ArrayList<String> viiteLista = new ArrayList();     //kokoelma viitteitä tulostustarpeisiin
    StyledDocument doku = lukualue.getStyledDocument();     //alustana viitteiden tulostuksille ja napeille
    SimpleAttributeSet muotoiluja = new SimpleAttributeSet();   //StyledDocument tarvii tämmöisenkin

    public void piirra() {

        paivita.setBounds(640, 20, 180, 40);
        paivita.setText("Päivitä luettelo");
        paivita.setFont(new Font("Arial", Font.BOLD, 14));
        paivita.setBackground(Color.green);

        luku.setBounds(20, 20, 550, 650);
        luku.setFont(new Font("Arial", Font.BOLD, 13));
        luku.setForeground(Color.black);

        lukualue.setBounds(20, 20, 550, 650);
        lukualue.setFont(new Font("Arial", Font.BOLD, 13));
        lukualue.setForeground(Color.black);
        lukualue.setText("Lukualue");

        UserWindow.muokkausPaneeli.add(paivita);
        UserWindow.muokkausPaneeli.add(luku);

        //-----------------------kuuntelija katselupainikkeelle----------------------------------
        paivita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lukualue.setText("");
                viiteLista.clear();
                JButton[] poistoNappi = new JButton[UserWindow.ohjausOlio.listaaViitteet().size()];
                JButton[] muokkaaNappi = new JButton[UserWindow.ohjausOlio.listaaViitteet().size()];
                int j = 0;

                //lisätään viitteiden tekstiesitykset ja luodaan nappeja niiden referenssien mukaan nimettyinä
                for (KirjaviiteRajapinta viite : UserWindow.ohjausOlio.listaaViitteet()) {
                    viiteLista.add(viite.toString());
                    poistoNappi[j] = new JButton("Poista " + viite.getRefrence());
                    muokkaaNappi[j] = new JButton("Muokkaa " + viite.getRefrence());
                    j++;
                }

                try {
                    for (int i = 0; i < viiteLista.size(); i++) {
                        doku.insertString(doku.getLength(), viiteLista.get(i), muotoiluja);
                        poistoNappi[i].addActionListener(this);
                        muokkaaNappi[i].addActionListener(this);
                        lukualue.insertComponent(poistoNappi[i]);
                        doku.insertString(doku.getLength(), "  ", muotoiluja);
                        lukualue.insertComponent(muokkaaNappi[i]);
                        doku.insertString(doku.getLength(), "\n", muotoiluja);                        
                    }

                } catch (BadLocationException ex) {
                }

                System.out.println(e.getActionCommand());
                //nyt tulostaa vain terminaaliin, mitä nappia painettiin
                //tähän viesti kontrollerille, joka hoitelee jatkotoimet?
            }

        });

    }

}
