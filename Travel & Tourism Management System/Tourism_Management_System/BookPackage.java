package Tourism_Management_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookPackage extends JFrame implements ActionListener {
    JButton Tcheck, bpackage, back;
    Choice cpackage;
    JTextField TP;
    JLabel lableusername, lableid, lablenumber, lablephone, lableTP;
    String Username;

    BookPackage(String Username) {
        this.Username = Username;
        setBounds(320, 105, 950, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel book = new JLabel("BOOK PAKCKAGE");
        book.setBounds(130, 5, 200, 25);
        book.setFont(new Font("Tahoma", Font.BOLD, 20));
        book.setForeground(Color.RED);
        add(book);

        JLabel T_username = new JLabel("Username :");
        T_username.setBounds(40, 60, 150, 25);
        T_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(T_username);

        lableusername = new JLabel();
        lableusername.setBounds(220, 60, 150, 25);
        lableusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableusername);

        JLabel slp = new JLabel("Select Package : ");
        slp.setBounds(40, 110, 150, 25);
        slp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(slp);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(220, 110, 200, 20);
        cpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cpackage);

        JLabel t_person = new JLabel("Total Person :");
        t_person.setBounds(40, 160, 150, 25);
        t_person.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(t_person);

        TP = new JTextField("1");
        TP.setBounds(220, 160, 200, 25);
        TP.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(TP);

        JLabel username_id = new JLabel("ID :");
        username_id.setBounds(40, 210, 150, 25);
        username_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(username_id);

        lableid = new JLabel();
        lableid.setBounds(220, 210, 150, 25);
        lableid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableid);

        JLabel T_number = new JLabel("ID Number :");
        T_number.setBounds(40, 260, 150, 25);
        T_number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(T_number);

        lablenumber = new JLabel();
        lablenumber.setBounds(220, 260, 150, 25);
        lablenumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablenumber);

        JLabel tfphone = new JLabel("Phone No :");
        tfphone.setBounds(40, 310, 150, 25);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfphone);

        lablephone = new JLabel();
        lablephone.setBounds(220, 310, 150, 25);
        lablephone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablephone);

        JLabel T_price = new JLabel("Total Price :");
        T_price.setBounds(40, 360, 150, 25);
        T_price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(T_price);

        lableTP = new JLabel();
        lableTP.setBounds(220, 360, 150, 25);
        lableTP.setFont(new Font("Tahoma", Font.BOLD, 15));
        lableTP.setForeground(Color.red);
        add(lableTP);

        try {
            Conn c = new Conn();
            String query = "select * from customerss where Username = '" + Username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lableusername.setText(rs.getString("Username"));
                lableid.setText(rs.getString("id"));
                lablenumber.setText(rs.getString("number"));
                lablephone.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        Tcheck = new JButton("Check Price");
        Tcheck.setBounds(60, 420, 130, 25);
        Tcheck.setBackground(Color.blue);
        Tcheck.setBorderPainted(false);
        Tcheck.setOpaque(true);
        Tcheck.setForeground(Color.white);
        Tcheck.addActionListener(this);
        add(Tcheck);

        bpackage = new JButton("Book Package");
        bpackage.setBounds(200, 420, 130, 25);
        bpackage.setBackground(Color.blue);
        bpackage.setBorderPainted(false);
        bpackage.setOpaque(true);
        bpackage.setForeground(Color.white);
        bpackage.addActionListener(this);
        add(bpackage);

        back = new JButton("Back");
        back.setBounds(350, 420, 130, 25);
        back.setBackground(Color.blue);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 100, 500, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Tcheck) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;

            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 24000;
            } else {
                cost += 32000;
            }

            int Persons = Integer.parseInt(TP.getText());
            cost *= Persons;
            lableTP.setText("Rs. " + cost);

        } else if (ae.getSource() == bpackage) {

            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('" + lableusername.getText() + "','"
                        + cpackage.getSelectedItem() + "','" + TP.getText() + "','" + lableid.getText() + "','"
                        + lablenumber.getText() + "','" + lablephone.getText() + "','" + lableTP.getText() + "')");

                JOptionPane.showMessageDialog(null, "Package Booked successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("");
    }
}
