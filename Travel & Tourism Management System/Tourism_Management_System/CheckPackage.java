package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.lang.String;

public class CheckPackage extends JFrame {
    JPanel createPackage;

    CheckPackage() {
        setBounds(340, 90, 900, 600);
        String[] package1 = { "GOLD PACKAGE", "6 Day and 7 Night's", "Airport Assistance", "Half Day City Tour",
                "Dailly Buffet", "Soft Drinks Free", "Full day 3 island Cruise", "Engalish Speking guide",
                "BOOK PACKAGE", "SUMMER SPECIAL", "Rs 12000/-", "package1.jpg" };
        String[] package2 = { "SILVER PACKAGE", "5 Day and 6 Night's", "Toll Free", "Entrance Free Tickets",
                "Meet and greet at Airport", "Welcome Drink on Arrival", "Night Safari", "Cruise with Dinner",
                "BOOK NOW", "WINTER SPECIAL", "Rs 24000/-", "package2.jpg" };
        String[] package3 = { "BRONZE PACKAGE", "8 Day and 7 Night's", "Return Airfare", "Free Clubbing",
                "Horse Riding & Other Game", "Hard Drinks Free", "Dailly Buffer", "BBQ Dinner", "BOOK NOW",
                "WINTER SPECIAL", "Rs 32000/-", "package3.jpg" };

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        JLabel l1 = new JLabel(pack[0]);
        l1.setFont(new Font("Tohoma", Font.BOLD, 30));
        l1.setBounds(50, 5, 300, 30);
        l1.setForeground(Color.GREEN);
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setFont(new Font("Tohoma", Font.BOLD, 20));
        l2.setBounds(30, 60, 300, 30);
        l2.setForeground(Color.red);
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setFont(new Font("Tohoma", Font.BOLD, 20));
        l3.setBounds(30, 110, 300, 30);
        l3.setForeground(Color.blue);
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setFont(new Font("Tohoma", Font.BOLD, 20));
        l4.setBounds(30, 160, 300, 30);
        l4.setForeground(Color.red);
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setFont(new Font("Tohoma", Font.BOLD, 20));
        l5.setBounds(30, 210, 300, 30);
        l5.setForeground(Color.blue);
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setFont(new Font("Tohoma", Font.BOLD, 20));
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(Color.red);
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setFont(new Font("Tohoma", Font.BOLD, 20));
        l7.setBounds(30, 310, 300, 30);
        l7.setForeground(Color.blue);
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setFont(new Font("Tohoma", Font.BOLD, 20));
        l8.setBounds(30, 360, 300, 30);
        l8.setForeground(Color.red);
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setFont(new Font("Tohoma", Font.BOLD, 25));
        l9.setBounds(60, 430, 300, 30);
        l9.setForeground(Color.black);
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setFont(new Font("Tohoma", Font.BOLD, 25));
        l10.setBounds(80, 480, 300, 30);
        l10.setForeground(Color.green);
        p1.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setFont(new Font("Tohoma", Font.BOLD, 25));
        l11.setBounds(500, 480, 300, 30);
        l11.setForeground(Color.CYAN);
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350, 20, 500, 300);
        p1.add(l12);
        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
