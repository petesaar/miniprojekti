package miniprojekti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author Jeesusteippaajat
 */
public class LisaysPaneeli {

    JButton lisaa = new JButton();    //lisäyspainike
    JLabel otsikko_pakolliset = new JLabel("Pakolliset kentät:");
    JLabel otsikko_vapaavalintaiset = new JLabel("Vapaavalintaiset kentät:");
    JLabel otsikko_referenssi = new JLabel("Referenssi:");
    JLabel otsikko_author = new JLabel("Tekijät (authors):");
    JLabel otsikko_title = new JLabel("Nimi (title):");
    JLabel otsikko_year = new JLabel("Vuosi (year):");
    JLabel otsikko_publisher = new JLabel("Julkaisija (publisher):");
    JLabel otsikko_booktitle = new JLabel("Booktitle:");
    JLabel otsikko_pages = new JLabel("Sivut (pages):");
    JLabel otsikko_address = new JLabel("Osoite (address):");
    JLabel otsikko_volume = new JLabel("Volume:");
    JLabel otsikko_number = new JLabel("Number:");
    JLabel otsikko_journal = new JLabel("Journal:");

    String[] vaihtoehdot = {"", "Book", "Article", "Inproceedings"};
    JComboBox tyyppi_boksi = new JComboBox(vaihtoehdot);

    JTextField author_kentta = new JTextField();    
    JTextField referenssi_kentta = new JTextField();   
    JTextField title_kentta = new JTextField();
    JTextField year_kentta = new JTextField();
    JTextField publisher_kentta = new JTextField();
    JTextField booktitle_kentta = new JTextField();
    JTextField pages_kentta = new JTextField();
    JTextField address_kentta = new JTextField();
    JTextField volume_kentta = new JTextField();
    JTextField number_kentta = new JTextField();
    static JTextField journal_kentta = new JTextField();

    JTextPane ilmoitusalue = new JTextPane();
    JScrollPane ilm = new JScrollPane(ilmoitusalue);

    String tyyppi = "";

    public void piirra() {

        lisaa.setBounds(50, 510, 120, 40);
        lisaa.setText("Lisää viite");
        lisaa.setFont(new Font("Arial", Font.BOLD, 14));
        lisaa.setBackground(Color.green);

        otsikko_pakolliset.setBounds(40, 40, 300, 40);
        otsikko_pakolliset.setFont(new Font("Arial", Font.BOLD, 18));
        otsikko_pakolliset.setForeground(Color.BLUE);

        otsikko_referenssi.setBounds(40, 90, 300, 40);
        otsikko_referenssi.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_referenssi.setForeground(Color.BLUE);

        otsikko_vapaavalintaiset.setBounds(440, 40, 300, 40);
        otsikko_vapaavalintaiset.setFont(new Font("Arial", Font.BOLD, 18));
        otsikko_vapaavalintaiset.setForeground(Color.BLUE);

        tyyppi_boksi.setBounds(40, 570, 150, 30);
        tyyppi_boksi.setSelectedIndex(0);
        tyyppi_boksi.setBackground(Color.white);

        otsikko_author.setBounds(40, 150, 200, 40);
        otsikko_author.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_author.setForeground(Color.BLUE);

        author_kentta.setBounds(40, 180, 300, 30);
        author_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        author_kentta.setForeground(Color.black);        

        referenssi_kentta.setBounds(40, 120, 300, 30);
        referenssi_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        referenssi_kentta.setForeground(Color.black);

        otsikko_title.setBounds(40, 220, 200, 40);
        otsikko_title.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_title.setForeground(Color.BLUE);

        title_kentta.setBounds(40, 250, 300, 30);
        title_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        title_kentta.setForeground(Color.black);       

        otsikko_year.setBounds(40, 290, 200, 40);
        otsikko_year.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_year.setForeground(Color.BLUE);

        year_kentta.setBounds(40, 320, 300, 30);
        year_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        year_kentta.setForeground(Color.black);       

        otsikko_publisher.setBounds(40, 360, 200, 40);
        otsikko_publisher.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_publisher.setForeground(Color.BLUE);

        publisher_kentta.setBounds(40, 390, 300, 30);
        publisher_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        publisher_kentta.setForeground(Color.black);     

        otsikko_booktitle.setBounds(440, 90, 200, 40);
        otsikko_booktitle.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_booktitle.setForeground(Color.BLUE);

        booktitle_kentta.setBounds(440, 120, 300, 30);
        booktitle_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        booktitle_kentta.setForeground(Color.black);       

        otsikko_pages.setBounds(440, 150, 200, 40);
        otsikko_pages.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_pages.setForeground(Color.BLUE);

        pages_kentta.setBounds(440, 180, 300, 30);
        pages_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        pages_kentta.setForeground(Color.black);     

        otsikko_address.setBounds(440, 220, 200, 40);
        otsikko_address.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_address.setForeground(Color.BLUE);

        address_kentta.setBounds(440, 250, 300, 30);
        address_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        address_kentta.setForeground(Color.black);     

        otsikko_volume.setBounds(440, 290, 200, 40);
        otsikko_volume.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_volume.setForeground(Color.BLUE);

        volume_kentta.setBounds(440, 320, 300, 30);
        volume_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        volume_kentta.setForeground(Color.black);    

        otsikko_number.setBounds(440, 360, 200, 40);
        otsikko_number.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_number.setForeground(Color.BLUE);

        number_kentta.setBounds(440, 390, 300, 30);
        number_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        number_kentta.setForeground(Color.black);     

        otsikko_journal.setBounds(440, 430, 200, 40);
        otsikko_journal.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_journal.setForeground(Color.BLUE);

        journal_kentta.setBounds(440, 460, 300, 30);
        journal_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        journal_kentta.setForeground(Color.black);      

        ilm.setBounds(240, 520, 500, 80);
        ilm.setFont(new Font("Arial", Font.BOLD, 13));
        ilm.setForeground(Color.black);

        ilmoitusalue.setBounds(240, 520, 500, 80);
        ilmoitusalue.setFont(new Font("Arial", Font.BOLD, 13));
        ilmoitusalue.setForeground(Color.black);
        ilmoitusalue.setText("Valitse ensin viitteen tyyppi pudotusvalikosta");

        UserWindow.lisaysPaneeli.add(ilm);
        UserWindow.lisaysPaneeli.add(tyyppi_boksi);

        //-----------------------kuuntelija lisäyspainikkeelle----------------------------------
        lisaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String tyyppi = tyyppi_boksi.getSelectedItem().toString().toLowerCase();
                Map<String, String> kentat = new HashMap();
                
                if (tyyppi.equals("book")) {
                    kentat.put("author", author_kentta.getText());
                    kentat.put("title", title_kentta.getText());
                    kentat.put("year", year_kentta.getText());
                    kentat.put("publisher", publisher_kentta.getText());
                    kentat.put("address", address_kentta.getText());
                    kentat.put("volume", volume_kentta.getText());
                    kentat.put("number", number_kentta.getText());
                    UserWindow.ohjausOlio.luoViite(tyyppi, referenssi_kentta.getText(), kentat);
                } else if (tyyppi.equals("article")) {
                    kentat.put("author", author_kentta.getText());
                    kentat.put("title", title_kentta.getText());
                    kentat.put("year", year_kentta.getText());
                    kentat.put("pages", pages_kentta.getText());
                    kentat.put("volume", volume_kentta.getText());
                    kentat.put("number", number_kentta.getText());
                    kentat.put("journal", journal_kentta.getText());
                    UserWindow.ohjausOlio.luoViite(tyyppi, referenssi_kentta.getText(), kentat);
                } else if (tyyppi.equals("inproceedings")) {
                    kentat.put("author", author_kentta.getText());
                    kentat.put("title", title_kentta.getText());
                    kentat.put("year", year_kentta.getText());
                    kentat.put("publisher", publisher_kentta.getText());
                    kentat.put("booktitle", booktitle_kentta.getText());
                    kentat.put("pages", pages_kentta.getText());
                    kentat.put("address", address_kentta.getText());
                    kentat.put("volume", volume_kentta.getText());
                    kentat.put("number", number_kentta.getText());
                    UserWindow.ohjausOlio.luoViite(tyyppi, referenssi_kentta.getText(), kentat);
                }
                
                String[] errors = UserWindow.ohjausOlio.getErrors();
                if (errors.length != 0) {
                    StringBuilder tuloste = new StringBuilder();
                    for (String error : errors) {
                        tuloste.append(error).append("\n");
                    }
                    ilmoitusalue.setText(tuloste.toString().substring(0, tuloste.toString().length() - 2));
                    return;
                }
                ilmoitusalue.setText( UserWindow.ohjausOlio.haeViimeksiLisattyKirjaviite());
            }
        });

        //-----------------------kuuntelija, tyypin valinta uudelle viitteelle----------------------------------
        tyyppi_boksi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tyyppi = "" + ((JComboBox) e.getSource()).getSelectedItem();
                
                UserWindow.lisaysPaneeli.removeAll();
                UserWindow.lisaysPaneeli.repaint();

                if (tyyppi.equals("Article")) {                    
                    //Required fields: author, title, journal, year, volume
                    //Optional fields: number, pages, month, note, key
                    UserWindow.lisaysPaneeli.add(lisaa);         //lisäyspainike                    
                    UserWindow.lisaysPaneeli.add(otsikko_referenssi);
                    UserWindow.lisaysPaneeli.add(referenssi_kentta);
                    referenssi_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_author);
                    UserWindow.lisaysPaneeli.add(author_kentta);
                    author_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_title);
                    UserWindow.lisaysPaneeli.add(title_kentta);
                    title_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_year);
                    UserWindow.lisaysPaneeli.add(year_kentta);
                    year_kentta.setBackground(new Color(255, 160, 122));                    
                    UserWindow.lisaysPaneeli.add(otsikko_pages);
                    UserWindow.lisaysPaneeli.add(pages_kentta);                  
                    UserWindow.lisaysPaneeli.add(otsikko_volume);
                    UserWindow.lisaysPaneeli.add(volume_kentta);
                    volume_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_journal);
                    UserWindow.lisaysPaneeli.add(journal_kentta);
                    journal_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_number);
                    UserWindow.lisaysPaneeli.add(number_kentta);
                }

                if (tyyppi.equals("Book")) {                    
                    //Required fields: author/editor, title, publisher, year
                    //Optional fields: volume/number, series, address, edition, month, note, key
                    UserWindow.lisaysPaneeli.add(lisaa);         //lisäyspainike                    
                    UserWindow.lisaysPaneeli.add(otsikko_referenssi);
                    UserWindow.lisaysPaneeli.add(otsikko_author);
                    UserWindow.lisaysPaneeli.add(author_kentta);
                    author_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(referenssi_kentta);
                    referenssi_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_title);
                    UserWindow.lisaysPaneeli.add(title_kentta);
                    title_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_year);
                    UserWindow.lisaysPaneeli.add(year_kentta);
                    year_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_publisher);
                    UserWindow.lisaysPaneeli.add(publisher_kentta);
                    publisher_kentta.setBackground(new Color(255, 160, 122));                    
                    UserWindow.lisaysPaneeli.add(otsikko_address);
                    UserWindow.lisaysPaneeli.add(address_kentta);
                    UserWindow.lisaysPaneeli.add(otsikko_volume);
                    UserWindow.lisaysPaneeli.add(volume_kentta);
                    volume_kentta.setBackground(Color.white);                    
                    UserWindow.lisaysPaneeli.add(otsikko_number);
                    UserWindow.lisaysPaneeli.add(number_kentta);                    
                }
                
                if (tyyppi.equals("Inproceedings")) {                    
                    //Required fields: author, title, booktitle, year
                    //Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key
                    UserWindow.lisaysPaneeli.add(lisaa);         //lisäyspainike                    
                    UserWindow.lisaysPaneeli.add(otsikko_referenssi);
                    UserWindow.lisaysPaneeli.add(referenssi_kentta); 
                    referenssi_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_author);
                    UserWindow.lisaysPaneeli.add(author_kentta);
                    author_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_title);
                    UserWindow.lisaysPaneeli.add(title_kentta);
                    title_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_year);
                    UserWindow.lisaysPaneeli.add(year_kentta);
                    year_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_publisher);
                    UserWindow.lisaysPaneeli.add(publisher_kentta);
                    publisher_kentta.setBackground(Color.white);       
                    UserWindow.lisaysPaneeli.add(otsikko_booktitle);
                    UserWindow.lisaysPaneeli.add(booktitle_kentta);
                    booktitle_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(otsikko_pages);
                    UserWindow.lisaysPaneeli.add(pages_kentta);
                    UserWindow.lisaysPaneeli.add(otsikko_address);
                    UserWindow.lisaysPaneeli.add(address_kentta);
                    UserWindow.lisaysPaneeli.add(otsikko_volume);
                    UserWindow.lisaysPaneeli.add(volume_kentta);
                    volume_kentta.setBackground(Color.white);               
                    UserWindow.lisaysPaneeli.add(otsikko_number);
                    UserWindow.lisaysPaneeli.add(number_kentta);
                }

                UserWindow.lisaysPaneeli.add(ilm);
                UserWindow.lisaysPaneeli.add(tyyppi_boksi);
                ilmoitusalue.setText("Värilliset kentät ovat pakollisia, valkoiset vapaavalintaisia.");
                UserWindow.lisaysPaneeli.revalidate();
                UserWindow.lisaysPaneeli.repaint();
            }
        });
    }

}
