package miniprojekti;

import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Kontrolleri.Kontrolleri;
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
    
    Kontrolleri ohjausOlio = new Kontrolleri();

    JButton lisaa = new JButton();    //lisäyspainike
    JLabel otsikko_pakolliset = new JLabel("Pakolliset kentät:");
    JLabel otsikko_vapaavalintaiset = new JLabel("Vapaavalintaiset kentät:");
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
    
    String[] vaihtoehdot = {"Book", "Article", "Inproceedings"};
    JComboBox kohde_boksi = new JComboBox(vaihtoehdot);
    
    JTextField author_kentta = new JTextField();
    JTextField title_kentta = new JTextField();
    JTextField year_kentta = new JTextField();
    JTextField publisher_kentta = new JTextField();
    JTextField booktitle_kentta = new JTextField();
    JTextField pages_kentta = new JTextField();
    JTextField address_kentta = new JTextField();
    JTextField volume_kentta = new JTextField();
    JTextField number_kentta = new JTextField();
    JTextField journal_kentta = new JTextField();

    String kohde = "Book";

    public void piirra() {

        lisaa.setBounds(130, 550, 120, 40);
        lisaa.setText("Lisää viite");
        lisaa.setFont(new Font("Arial", Font.BOLD, 14));
        lisaa.setBackground(Color.green);

        otsikko_pakolliset.setBounds(40, 40, 200, 40);
        otsikko_pakolliset.setFont(new Font("Arial", Font.BOLD, 16));
        otsikko_pakolliset.setForeground(Color.BLUE);

        otsikko_vapaavalintaiset.setBounds(440, 40, 200, 40);
        otsikko_vapaavalintaiset.setFont(new Font("Arial", Font.BOLD, 16));
        otsikko_vapaavalintaiset.setForeground(Color.BLUE);

        kohde_boksi.setBounds(40, 100, 150, 30);
        kohde_boksi.setSelectedIndex(0);       
        kohde_boksi.setBackground(Color.white);

        otsikko_author.setBounds(40, 150, 200, 40);
        otsikko_author.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_author.setForeground(Color.BLUE);

        author_kentta.setBounds(40, 180, 300, 30);
        author_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        author_kentta.setForeground(Color.black);
        //author_kentta.setText("Author(s)");

        otsikko_title.setBounds(40, 220, 200, 40);
        otsikko_title.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_title.setForeground(Color.BLUE);

        title_kentta.setBounds(40, 250, 300, 30);
        title_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        title_kentta.setForeground(Color.black);
        //title_kentta.setText("Title");

        otsikko_year.setBounds(40, 290, 200, 40);
        otsikko_year.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_year.setForeground(Color.BLUE);

        year_kentta.setBounds(40, 320, 300, 30);
        year_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        year_kentta.setForeground(Color.black);
        //year_kentta.setText("Year");

        otsikko_publisher.setBounds(40, 360, 200, 40);
        otsikko_publisher.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_publisher.setForeground(Color.BLUE);

        publisher_kentta.setBounds(40, 390, 300, 30);
        publisher_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        publisher_kentta.setForeground(Color.black);
        //publisher_kentta.setText("Publisher");

        otsikko_booktitle.setBounds(440, 90, 200, 40);
        otsikko_booktitle.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_booktitle.setForeground(Color.BLUE);

        booktitle_kentta.setBounds(440, 120, 300, 30);
        booktitle_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        booktitle_kentta.setForeground(Color.black);
        //booktitle_kentta.setText("Booktitle");

        otsikko_pages.setBounds(440, 150, 200, 40);
        otsikko_pages.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_pages.setForeground(Color.BLUE);

        pages_kentta.setBounds(440, 180, 300, 30);
        pages_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        pages_kentta.setForeground(Color.black);
       //pages_kentta.setText("Pages");

        otsikko_address.setBounds(440, 220, 200, 40);
        otsikko_address.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_address.setForeground(Color.BLUE);

        address_kentta.setBounds(440, 250, 300, 30);
        address_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        address_kentta.setForeground(Color.black);
        //address_kentta.setText("Address");

        otsikko_volume.setBounds(440, 290, 200, 40);
        otsikko_volume.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_volume.setForeground(Color.BLUE);

        volume_kentta.setBounds(440, 320, 300, 30);
        volume_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        volume_kentta.setForeground(Color.black);
        //volume_kentta.setText("Volume");

        otsikko_number.setBounds(440, 360, 200, 40);
        otsikko_number.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_number.setForeground(Color.BLUE);

        number_kentta.setBounds(440, 390, 300, 30);
        number_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        number_kentta.setForeground(Color.black);
        //number_kentta.setText("Number");

        otsikko_journal.setBounds(440, 430, 200, 40);
        otsikko_journal.setFont(new Font("Arial", Font.BOLD, 13));
        otsikko_journal.setForeground(Color.BLUE);

        journal_kentta.setBounds(440, 460, 300, 30);
        journal_kentta.setFont(new Font("Arial", Font.BOLD, 13));
        journal_kentta.setForeground(Color.black);
        //journal_kentta.setText("Journal");

        UserWindow.lisaysPaneeli.add(lisaa);         //lisäyspainike
        UserWindow.lisaysPaneeli.add(otsikko_pakolliset);
        UserWindow.lisaysPaneeli.add(otsikko_vapaavalintaiset);
        UserWindow.lisaysPaneeli.add(otsikko_author);
        UserWindow.lisaysPaneeli.add(author_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_title);
        UserWindow.lisaysPaneeli.add(title_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_year);
        UserWindow.lisaysPaneeli.add(year_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_publisher);
        UserWindow.lisaysPaneeli.add(publisher_kentta);
        UserWindow.lisaysPaneeli.add(kohde_boksi);
        UserWindow.lisaysPaneeli.add(otsikko_booktitle);
        UserWindow.lisaysPaneeli.add(booktitle_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_pages);
        UserWindow.lisaysPaneeli.add(pages_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_address);
        UserWindow.lisaysPaneeli.add(address_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_volume);
        UserWindow.lisaysPaneeli.add(volume_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_number);
        UserWindow.lisaysPaneeli.add(number_kentta);
        UserWindow.lisaysPaneeli.add(otsikko_journal);
        UserWindow.lisaysPaneeli.add(journal_kentta);

        //-----------------------kuuntelija lisäyspainikkeelle----------------------------------
        lisaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kirjaviite uusi = ohjausOlio.luoKirjaviite();
                uusi.setAuthor(author_kentta.getText());
                uusi.setPublisher(publisher_kentta.getText());
                uusi.setTitle(title_kentta.getText());
                uusi.setYear(year_kentta.getText());
                System.out.println("valinta: "+kohde);
                System.out.println("tiedot: "+uusi);
            }
        });

        //-----------------------kuuntelija, kohteen valinta uudelle viitteelle----------------------------------
        kohde_boksi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kohde = "" + ((JComboBox) e.getSource()).getSelectedItem();
            }
        });
    }

}
