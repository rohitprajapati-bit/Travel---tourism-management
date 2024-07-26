package Tourism_Management_System;

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

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    JLabel lablepackage, lableusername, lable_t_P, lableid, lableprice, lablephone, lablenumber;
    String Username;

    ViewPackage(String Username) {
        setBounds(350, 120, 900, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(50, 20, 400, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setForeground(Color.blue);
        add(text);

        JLabel T_username = new JLabel("Username :");
        T_username.setBounds(30, 70, 150, 25);
        T_username.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_username);

        lableusername = new JLabel();
        lableusername.setBounds(220, 70, 150, 25);
        lableusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableusername);

        JLabel username_package = new JLabel("Package :");
        username_package.setBounds(30, 110, 150, 25);
        username_package.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(username_package);

        lablepackage = new JLabel();
        lablepackage.setBounds(220, 110, 150, 25);
        lablepackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablepackage);

        JLabel Person = new JLabel("Total Person :");
        Person.setBounds(30, 150, 150, 25);
        Person.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Person);

        lable_t_P = new JLabel();
        lable_t_P.setBounds(220, 150, 150, 25);
        lable_t_P.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lable_t_P);

        JLabel tId = new JLabel("ID :");
        tId.setBounds(30, 190, 150, 25);
        tId.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tId);

        lableid = new JLabel();
        lableid.setBounds(220, 190, 150, 25);
        lableid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableid);

        JLabel number = new JLabel("ID Number :");
        number.setBounds(30, 240, 150, 25);
        number.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(number);

        lablenumber = new JLabel();
        lablenumber.setBounds(220, 240, 150, 25);
        lablenumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablenumber);

        JLabel tphone = new JLabel("Phone No :");
        tphone.setBounds(30, 280, 150, 25);
        tphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tphone);

        lablephone = new JLabel();
        lablephone.setBounds(220, 280, 150, 25);
        lablephone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablephone);

        JLabel tfPrice = new JLabel("Price :");
        tfPrice.setBounds(30, 320, 150, 25);
        tfPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfPrice);

        lableprice = new JLabel();
        lableprice.setBounds(220, 320, 150, 25);
        lableprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableprice);

        back = new JButton("Back");
        back.setBounds(80, 400, 100, 25);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 30, 500, 400);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where Username = '" + Username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lableusername.setText(rs.getString("Username"));
                lableid.setText(rs.getString("id"));
                lablenumber.setText(rs.getString("number"));
                lablephone.setText(rs.getString("phone"));
                lableprice.setText(rs.getString("price"));
                lablepackage.setText(rs.getString("package"));
                lable_t_P.setText(rs.getString("person"));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage(" ");
    }
}
