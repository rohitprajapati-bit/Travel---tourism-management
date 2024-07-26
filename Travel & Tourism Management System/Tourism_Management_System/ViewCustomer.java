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

public class ViewCustomer extends JFrame implements ActionListener {
    String Username;

    ViewCustomer(String Username) {
        this.Username = Username;

        setBounds(410, 100, 750, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW COSTOMER DETAILS");
        text.setBounds(200, 0, 400, 25);
        text.setFont(new Font("Ralay", Font.BOLD, 20));
        text.setForeground(Color.blue);
        add(text);

        JLabel T_username = new JLabel("Username  :");
        T_username.setBounds(30, 50, 150, 25);
        T_username.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_username);

        JLabel lableusername = new JLabel();
        lableusername.setBounds(180, 50, 150, 25);
        lableusername.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lableusername);

        JLabel username_id = new JLabel("ID  :");
        username_id.setBounds(30, 130, 150, 25);
        username_id.setFont(new Font("Ralay", Font.BOLD, 15));
        add(username_id);

        JLabel labaleid = new JLabel();
        labaleid.setBounds(180, 130, 150, 25);
        labaleid.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labaleid);

        JLabel T_number = new JLabel("ID Number  :");
        T_number.setBounds(30, 170, 150, 25);
        T_number.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_number);

        JLabel lablenumber = new JLabel();
        lablenumber.setBounds(180, 170, 150, 25);
        lablenumber.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablenumber);

        JLabel userName = new JLabel("Name  :");
        userName.setBounds(30, 90, 150, 25);
        userName.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userName);

        JLabel lablename = new JLabel();
        lablename.setBounds(180, 90, 150, 25);
        lablename.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablename);

        JLabel usergender = new JLabel("Gender  :");
        usergender.setBounds(30, 210, 150, 25);
        usergender.setFont(new Font("Ralay", Font.BOLD, 15));
        add(usergender);

        JLabel lablegender = new JLabel();
        lablegender.setBounds(180, 210, 150, 25);
        lablegender.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablegender);

        JLabel Country = new JLabel("Country  :");
        Country.setBounds(450, 50, 150, 25);
        Country.setFont(new Font("Ralay", Font.BOLD, 15));
        add(Country);

        JLabel lablecountry = new JLabel();
        lablecountry.setBounds(550, 50, 150, 25);
        lablecountry.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablecountry);

        JLabel tfAddress = new JLabel("Address  :");
        tfAddress.setBounds(450, 90, 150, 25);
        tfAddress.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfAddress);

        JLabel lableaddress = new JLabel();
        lableaddress.setBounds(550, 90, 150, 25);
        lableaddress.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lableaddress);

        JLabel tfphone = new JLabel("Mobile No  :");
        tfphone.setBounds(450, 130, 150, 25);
        tfphone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfphone);

        JLabel lablephone = new JLabel();
        lablephone.setBounds(550, 130, 150, 25);
        lablephone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablephone);

        JLabel tfEmail = new JLabel("Email Id  :");
        tfEmail.setBounds(450, 170, 150, 25);
        tfEmail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfEmail);

        JLabel lableemail = new JLabel();
        lableemail.setBounds(550, 170, 150, 25);
        lableemail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lableemail);

        JButton back = new JButton("Back");
        back.setBounds(300, 280, 76, 25);
        back.setBackground(Color.black);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 350, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(610, 350, 600, 200);
        add(image2);
        try {
            Conn c = new Conn();
            String query = "select *from customerss where Username = '" + Username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lableusername.setText(rs.getString("Username"));
                labaleid.setText(rs.getString("id"));
                lablenumber.setText(rs.getString("number"));
                lablename.setText(rs.getString("name"));
                lablegender.setText(rs.getString("gender"));
                lablecountry.setText(rs.getString("country"));
                lableaddress.setText(rs.getString("address"));
                lablephone.setText(rs.getString("phone"));
                lableemail.setText(rs.getString("email"));

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
        new ViewCustomer("");
    }
}
