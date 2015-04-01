package miniprojekti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JPanel implements ActionListener {
    
    JLayeredPane tausta = new JLayeredPane();
    static JButton loppuNappula = new JButton("Sulje ohjelma");
    
    public UserWindow(){
        tausta.setPreferredSize(new Dimension(1200, 800));
        tausta.setLayout(null);
        add(tausta);
        
        loppuNappula.setBounds(800, 50, 180, 40);        
        loppuNappula.setFont(new Font("Arial", Font.BOLD, 16));
        loppuNappula.addActionListener(this);        
        tausta.add(loppuNappula);
    }

    public void actionPerformed(ActionEvent e) {
        Object aiheuttaja = e.getSource();
        if (aiheuttaja == loppuNappula) {            
                System.exit(0);         
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.GRAY);
    }

}
