package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ChoiceFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton Tcheck, bpackage, back;
    ChoiceFormat cpackage, cAc, Food;
    JTextField TP;

    JLabel labelhotel, labelusername, labelperson, labelDays, labelAC, labelACinclude, labelFIN, labelID, labelNUMBER,
            labelPhone, labelPrice;

    ViewBookedHotel(String Username) {

        // setBounds(300, 70, 1050, 700);
        setBounds(333, 88, 900, 590);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel book = new JLabel("VIEW BOOKED HOTEL DETAILS");
        book.setBounds(470, 20, 500, 50);
        book.setFont(new Font("Tahoma", Font.BOLD, 25));
        book.setForeground(Color.blue);
        add(book);

        JLabel T_username = new JLabel("Username :");
        T_username.setBounds(15, 60, 150, 25);
        T_username.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(T_username);

        labelusername = new JLabel();
        labelusername.setBounds(180, 60, 150, 25);
        labelusername.setFont(new Font("Ralay", Font.BOLD, 15));

        add(labelusername);

        JLabel slp = new JLabel("Hotel Name :");
        slp.setBounds(15, 110, 150, 25);
        slp.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(slp);

        labelhotel = new JLabel();
        labelhotel.setBounds(180, 110, 150, 25);
        labelhotel.setFont(new Font("Ralay", Font.BOLD, 15));

        add(labelhotel);

        JLabel t_person = new JLabel("Total Person :");
        t_person.setBounds(15, 160, 150, 25);
        t_person.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(t_person);

        labelperson = new JLabel();
        labelperson.setBounds(180, 160, 150, 25);
        labelperson.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelperson);

        JLabel day = new JLabel("Total Days :");
        day.setBounds(15, 210, 150, 25);
        day.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(day);

        labelDays = new JLabel();
        labelDays.setBounds(180, 210, 150, 25);
        labelDays.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelDays);

        JLabel T_includ = new JLabel("AC Included? :");
        T_includ.setBounds(15, 260, 150, 25);
        T_includ.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(T_includ);

        labelACinclude = new JLabel();
        labelACinclude.setBounds(180, 260, 150, 25);
        labelACinclude.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelACinclude);

        JLabel userName = new JLabel("Food Included :");
        userName.setBounds(15, 310, 150, 25);
        userName.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(userName);

        labelFIN = new JLabel();
        labelFIN.setBounds(180, 310, 150, 25);
        labelFIN.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelFIN);

        JLabel tfphone = new JLabel("ID :");
        tfphone.setBounds(15, 360, 150, 25);
        tfphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(tfphone);

        labelID = new JLabel();
        labelID.setBounds(180, 360, 150, 25);
        labelID.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelID);

        JLabel T_Number = new JLabel("ID Number :");
        T_Number.setBounds(15, 410, 150, 25);
        T_Number.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(T_Number);

        labelNUMBER = new JLabel();
        labelNUMBER.setBounds(180, 410, 150, 25);
        labelNUMBER.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelNUMBER);

        JLabel T_phone = new JLabel(" Phone No :");
        T_phone.setBounds(15, 460, 150, 25);
        T_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(T_phone);

        labelPhone = new JLabel();
        labelPhone.setBounds(180, 460, 150, 25);
        labelPhone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelPhone);

        JLabel T_price = new JLabel(" Total Price :");
        T_price.setBounds(15, 510, 150, 25);
        T_price.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(T_price);

        labelPrice = new JLabel();
        labelPrice.setBounds(180, 510, 150, 25);
        labelPrice.setFont(new Font("Ralay", Font.BOLD, 15));
        labelPrice.setForeground(Color.red);
        add(labelPrice);

        back = new JButton("Back");
        back.setBounds(650, 450, 76, 25);
        back.setBackground(Color.black);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 70, 550, 400);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from bookHotels where Username = '" + Username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelID.setText(rs.getString("id"));
                labelNUMBER.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
                labelPrice.setText(rs.getString("price"));
                labelhotel.setText(rs.getString("name"));
                labelperson.setText(rs.getString("person"));
                labelFIN.setText(rs.getString("food"));
                labelACinclude.setText(rs.getString("ac"));
                labelDays.setText(rs.getString("days"));

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
        new ViewBookedHotel("");
    }
}
