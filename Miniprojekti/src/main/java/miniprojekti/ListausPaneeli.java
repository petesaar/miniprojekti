package miniprojekti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import static miniprojekti.UserWindow.ohjausOlio;
import miniprojekti.Viite.Viite;

/**
 *
 * @author Jeesusteippaajat
 */
public class ListausPaneeli {
    
    int viitteita = 0;
    JButton tallennaBib = new JButton();               //tallennuspainike bibtex-tiedostolle
    JButton tallennaJson = new JButton();               //tallennuspainike bibtex-tiedostolle
    static JButton paivita = new JButton();                    //katso tallennetut viitteet
    JTextPane lukualue = new JTextPane();           //tekstialue viitteille
    JScrollPane luku = new JScrollPane(lukualue);    //scrollaava tekstialue
    JLabel sinullaOn = new JLabel("Viitteitä yhteensä: "+viitteita);
    
    ArrayList<String> viiteLista = new ArrayList();     //kokoelma viitteitä tulostustarpeisiin
    StyledDocument doku = lukualue.getStyledDocument();     //alustana viitteiden tulostuksille ja napeille
    SimpleAttributeSet muotoiluja = new SimpleAttributeSet();   //StyledDocument tarvii tämmöisenkin
    
    

    public void piirra() {        
        
        sinullaOn.setBounds(600, 20, 300, 40);
        sinullaOn.setFont(new Font("Verdana", Font.BOLD, 16));
        sinullaOn.setForeground(Color.white);

        paivita.setBounds(600, 320, 220, 40);
        paivita.setText("Päivitä luettelo");
        paivita.setFont(new Font("Verdana", Font.BOLD, 13));
        paivita.setBackground(new Color(144,238,144));
        paivita.setVisible(false);
        
        tallennaJson.setBounds(600, 120, 220, 40);
        tallennaJson.setText("Tallenna JSON-tiedosto");
        tallennaJson.setFont(new Font("Verdana", Font.BOLD, 13));
        tallennaJson.setBackground(new Color(144,238,144));        
        
        tallennaBib.setBounds(600, 200, 220, 40);
        tallennaBib.setText("Tallenna BIB-tiedosto");
        tallennaBib.setFont(new Font("Verdana", Font.BOLD, 13));
        tallennaBib.setBackground(new Color(175,238,238));
        
        luku.setBounds(20, 20, 550, 630);
        luku.setFont(new Font("Verdana", Font.BOLD, 13));
        luku.setForeground(Color.black);
        
        lukualue.setBounds(20, 20, 550, 630);
        lukualue.setFont(new Font("Verdana", Font.BOLD, 13));
        lukualue.setForeground(Color.black);
        lukualue.setText("Lukualue");
        lukualue.setBackground( new Color(220, 220, 220));        
        
        UserWindow.listausPaneeli.add(sinullaOn);
        UserWindow.listausPaneeli.add(paivita);        
        UserWindow.listausPaneeli.add(luku); 
        UserWindow.listausPaneeli.add(tallennaBib); 
        UserWindow.listausPaneeli.add(tallennaJson); 
        
        
        //---------------------------------------------------------------------
        
        tallennaBib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserWindow.ohjausOlio.tallennaViitteet();
            }
        });
        
        tallennaJson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               UserWindow.ohjausOlio.tallennaJsoniin();
            }
        });
        
        
        paivita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viitteita = UserWindow.ohjausOlio.listaaViitteet().size();
                sinullaOn.setText("Viitteitä yhteensä: "+viitteita);
                lukualue.setText("");
                viiteLista.clear();
                JButton[] poistoNappi = new JButton[viitteita];                
                int j = 0;

                //lisätään viitteiden tekstiesitykset ja luodaan nappeja niiden bibtexkeyn mukaan nimettyinä
                for (Viite viite : UserWindow.ohjausOlio.listaaViitteet()) {
                    viiteLista.add(viite.toString());
                    poistoNappi[j] = new JButton("Poista " + viite.getRefrence());                    
                    j++;
                }

                try {
                    for (int i = 0; i < viiteLista.size(); i++) {
                        doku.insertString(doku.getLength(), viiteLista.get(i), muotoiluja);
                        poistoNappi[i].addActionListener(this);                       
                        lukualue.insertComponent(poistoNappi[i]);                        
                        doku.insertString(doku.getLength(), "\n\n", muotoiluja);                        
                    }

                } catch (BadLocationException ex) {
                }

                
                //jos painettu Poista x -nappia, kontrollerille komentopyyntö:
                String klikattuNappula = e.getActionCommand();
                if(klikattuNappula.contains("Poista")){
                    //System.out.println("Painoit nappulaa "+klikattuNappula);
                    UserWindow.ohjausOlio.poistaViite(klikattuNappula);
                    ListausPaneeli.paivita.doClick();
                }                
            }
        });
    }
    public void aloitus(){
        ListausPaneeli.paivita.doClick();
    }
}
