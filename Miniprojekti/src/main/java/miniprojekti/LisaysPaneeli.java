package miniprojekti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author Jeesusteippaajat
 */
public class LisaysPaneeli {

    JButton lisaa = new JButton();    //lisäyspainike    
    JLabel otsikko_bibtexkey = new JLabel("Bibtex Key:");
    JLabel otsikko_author = new JLabel("Author(s):");
    JLabel otsikko_title = new JLabel("Title:");
    JLabel otsikko_year = new JLabel("Year:");
    JLabel otsikko_publisher = new JLabel("Publisher:");
    JLabel otsikko_booktitle = new JLabel("Booktitle:");
    JLabel otsikko_pages = new JLabel("Pages:");
    JLabel otsikko_address = new JLabel("Address:");
    JLabel otsikko_volume = new JLabel("Volume:");
    JLabel otsikko_number = new JLabel("Number:");
    JLabel otsikko_journal = new JLabel("Journal:");

    String[] vaihtoehdot = {"", "Book", "Article", "Inproceedings"};
    JComboBox tyyppi_boksi = new JComboBox(vaihtoehdot);

    JTextField author_kentta = new JTextField();    
    JTextField bibtexkey_kentta = new JTextField();   
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

        lisaa.setBounds(50, 580, 120, 40);
        lisaa.setText("Lisää viite");
        lisaa.setFont(new Font("Verdana", Font.BOLD, 14));
        lisaa.setBackground(Color.green);
        
        otsikko_bibtexkey.setBounds(40, 90, 300, 40);
        otsikko_bibtexkey.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_bibtexkey.setForeground(Color.white);
        
        tyyppi_boksi.setBounds(40, 520, 150, 30);
        tyyppi_boksi.setSelectedIndex(0);
        tyyppi_boksi.setBackground(new Color(220, 220, 220));

        otsikko_author.setBounds(40, 150, 200, 40);
        otsikko_author.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_author.setForeground(Color.white);

        author_kentta.setBounds(40, 180, 300, 30);
        author_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        author_kentta.setForeground(Color.black);        

        bibtexkey_kentta.setBounds(40, 120, 300, 30);
        bibtexkey_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        bibtexkey_kentta.setForeground(Color.black);

        otsikko_title.setBounds(40, 220, 200, 40);
        otsikko_title.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_title.setForeground(Color.white);

        title_kentta.setBounds(40, 250, 300, 30);
        title_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        title_kentta.setForeground(Color.black);       

        otsikko_year.setBounds(40, 290, 200, 40);
        otsikko_year.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_year.setForeground(Color.white);

        year_kentta.setBounds(40, 320, 300, 30);
        year_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        year_kentta.setForeground(Color.black);       

        otsikko_publisher.setBounds(40, 360, 200, 40);
        otsikko_publisher.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_publisher.setForeground(Color.white);

        publisher_kentta.setBounds(40, 390, 300, 30);
        publisher_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        publisher_kentta.setForeground(Color.black);     

        otsikko_booktitle.setBounds(440, 90, 200, 40);
        otsikko_booktitle.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_booktitle.setForeground(Color.white);

        booktitle_kentta.setBounds(440, 120, 300, 30);
        booktitle_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        booktitle_kentta.setForeground(Color.black);       

        otsikko_pages.setBounds(440, 150, 200, 40);
        otsikko_pages.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_pages.setForeground(Color.white);

        pages_kentta.setBounds(440, 180, 300, 30);
        pages_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        pages_kentta.setForeground(Color.black);     

        otsikko_address.setBounds(440, 220, 200, 40);
        otsikko_address.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_address.setForeground(Color.white);

        address_kentta.setBounds(440, 250, 300, 30);
        address_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        address_kentta.setForeground(Color.black);     

        otsikko_volume.setBounds(440, 290, 200, 40);
        otsikko_volume.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_volume.setForeground(Color.white);

        volume_kentta.setBounds(440, 320, 300, 30);
        volume_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        volume_kentta.setForeground(Color.black);    

        otsikko_number.setBounds(440, 360, 200, 40);
        otsikko_number.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_number.setForeground(Color.white);

        number_kentta.setBounds(440, 390, 300, 30);
        number_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        number_kentta.setForeground(Color.black);     

        otsikko_journal.setBounds(440, 430, 200, 40);
        otsikko_journal.setFont(new Font("Verdana", Font.BOLD, 13));
        otsikko_journal.setForeground(Color.white);

        journal_kentta.setBounds(440, 460, 300, 30);
        journal_kentta.setFont(new Font("Verdana", Font.BOLD, 13));
        journal_kentta.setForeground(Color.black);      

        ilm.setBounds(240, 520, 500, 130);
        ilm.setFont(new Font("Verdana", Font.BOLD, 13));
        ilm.setForeground(Color.black);

        ilmoitusalue.setBounds(240, 520, 500, 130);
        ilmoitusalue.setFont(new Font("Verdana", Font.BOLD, 13));
        ilmoitusalue.setForeground(Color.black);
        ilmoitusalue.setText("Valitse ensin viitteen tyyppi pudotusvalikosta.");
        ilmoitusalue.setBackground( new Color(220, 220, 220));

        UserWindow.lisaysPaneeli.add(ilm);
        UserWindow.lisaysPaneeli.add(tyyppi_boksi);

        //-----------------------kuuntelija lisäyspainikkeelle----------------------------------
        lisaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String tyyppi = tyyppi_boksi.getSelectedItem().toString().toLowerCase();
                Map<String, String> kentat = new HashMap();
                
                // kontrolleri on vastuussa hashmapin käsittelystä; voi lisätä kaikki kentät
                kentat.put("author", author_kentta.getText());
                kentat.put("title", title_kentta.getText());
                kentat.put("year", year_kentta.getText());
                kentat.put("publisher", publisher_kentta.getText());
                kentat.put("address", address_kentta.getText());
                kentat.put("volume", volume_kentta.getText());
                kentat.put("number", number_kentta.getText());
                kentat.put("journal", journal_kentta.getText());
                kentat.put("booktitle", booktitle_kentta.getText());
                kentat.put("pages", pages_kentta.getText());
                UserWindow.ohjausOlio.luoViite(tyyppi, bibtexkey_kentta.getText(), kentat);
                
                List<String> errors = UserWindow.ohjausOlio.getErrors();
                if (errors.size() != 0) {
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
                    UserWindow.lisaysPaneeli.add(lisaa); 
                    UserWindow.lisaysPaneeli.add(otsikko_bibtexkey);
                    UserWindow.lisaysPaneeli.add(bibtexkey_kentta);
                    bibtexkey_kentta.setBackground(new Color(255, 160, 122));
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
                    
                    publisher_kentta.setText("");
                    address_kentta.setText("");
                    booktitle_kentta.setText("");
                }

                if (tyyppi.equals("Book")) {                    
                    //Required fields: author/editor, title, publisher, year
                    //Optional fields: volume/number, series, address, edition, month, note, key
                    UserWindow.lisaysPaneeli.add(lisaa);
                    UserWindow.lisaysPaneeli.add(otsikko_bibtexkey);
                    UserWindow.lisaysPaneeli.add(otsikko_author);
                    UserWindow.lisaysPaneeli.add(author_kentta);
                    author_kentta.setBackground(new Color(255, 160, 122));
                    UserWindow.lisaysPaneeli.add(bibtexkey_kentta);
                    bibtexkey_kentta.setBackground(new Color(255, 160, 122));
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
                    
                    booktitle_kentta.setText("");
                    number_kentta.setText("");
                    journal_kentta.setText("");
                    pages_kentta.setText("");
                }
                
                if (tyyppi.equals("Inproceedings")) {                    
                    //Required fields: author, title, booktitle, year
                    //Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key
                    UserWindow.lisaysPaneeli.add(lisaa);
                    UserWindow.lisaysPaneeli.add(otsikko_bibtexkey);
                    UserWindow.lisaysPaneeli.add(bibtexkey_kentta); 
                    bibtexkey_kentta.setBackground(new Color(255, 160, 122));
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
                    
                    journal_kentta.setText("");
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
