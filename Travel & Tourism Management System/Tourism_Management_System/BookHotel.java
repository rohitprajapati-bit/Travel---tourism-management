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

public class BookHotel extends JFrame implements ActionListener {

    JButton Tcheck, bpackage, back;
    Choice chotel, cAc, Food;
    JTextField Tperson, Tday;
    JLabel JLabelid, JLabelnumber, JLabelphone, JLabeltp, labelusername;
    String Username;

    BookHotel(String Username) {
        this.Username = Username;

        setBounds(330, 90, 900, 590);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel book = new JLabel("BOOK HOTEL");
        book.setBounds(150, 15, 200, 25);
        book.setFont(new Font("Tahoma", Font.BOLD, 25));
        book.setForeground(Color.red);
        add(book);

        JLabel T_username = new JLabel("Username :");
        T_username.setBounds(40, 60, 150, 25);
        T_username.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_username);

        labelusername = new JLabel();
        labelusername.setBounds(220, 60, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);

        JLabel slp = new JLabel("Select Hotel :");
        slp.setBounds(40, 110, 150, 25);
        slp.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(slp);

        chotel = new Choice();
        chotel.setBounds(220, 110, 180, 25);
        chotel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Hotelss");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel t_person = new JLabel("Total Person :");
        t_person.setBounds(40, 160, 150, 25);
        t_person.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(t_person);

        Tperson = new JTextField("1");
        Tperson.setBounds(220, 160, 180, 25);
        Tperson.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Tperson);

        JLabel day = new JLabel("No.of Day :");
        day.setBounds(40, 210, 150, 25);
        day.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(day);

        Tday = new JTextField("1");
        Tday.setBounds(220, 210, 180, 25);
        Tday.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Tday);

        JLabel T_number = new JLabel("AC/Non-AC :");
        T_number.setBounds(40, 260, 150, 25);
        T_number.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_number);

        cAc = new Choice();
        cAc.add("AC");
        cAc.add("Non-AC");
        cAc.setBounds(220, 260, 180, 25);
        cAc.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cAc);

        JLabel userName = new JLabel("Food Included :");
        userName.setBounds(40, 310, 150, 25);
        userName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(userName);

        Food = new Choice();
        Food.add("YES");
        Food.add("NO");
        Food.setBounds(220, 310, 180, 25);
        Food.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Food);

        JLabel tfid = new JLabel("ID :");
        tfid.setBounds(40, 360, 150, 25);
        tfid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfid);

        JLabelid = new JLabel();
        JLabelid.setBounds(220, 360, 180, 25);
        JLabelid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(JLabelid);

        JLabel T_Number = new JLabel("ID Number :");
        T_Number.setBounds(40, 410, 150, 25);
        T_Number.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_Number);

        JLabelnumber = new JLabel();
        JLabelnumber.setBounds(220, 410, 180, 25);
        JLabelnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(JLabelnumber);

        JLabel T_phone = new JLabel(" Mobile No :");
        T_phone.setBounds(40, 460, 150, 25);
        T_phone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_phone);

        JLabelphone = new JLabel();
        JLabelphone.setBounds(220, 460, 180, 25);
        JLabelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(JLabelphone);

        JLabel T_price = new JLabel(" Total Price :");
        T_price.setBounds(40, 510, 150, 25);
        T_price.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(T_price);

        JLabeltp = new JLabel();
        JLabeltp.setBounds(220, 510, 180, 25);
        JLabeltp.setFont(new Font("Tahoma", Font.BOLD, 15));
        JLabeltp.setForeground(Color.red);
        add(JLabeltp);

        try {
            Conn c = new Conn();
            String query = "select *from customerss where Username = '" + Username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                JLabelid.setText(rs.getString("id"));
                JLabelnumber.setText(rs.getString("number"));
                JLabelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tcheck = new JButton("Check Price");
        Tcheck.setBounds(450, 400, 130, 25);
        Tcheck.setFont(new Font("Tahoma", Font.BOLD, 15));
        Tcheck.setBackground(Color.blue);
        Tcheck.setBorderPainted(false);
        Tcheck.setOpaque(true);
        Tcheck.setForeground(Color.white);
        Tcheck.addActionListener(this);
        add(Tcheck);

        bpackage = new JButton("Book hotel");
        bpackage.setBounds(590, 400, 130, 25);
        bpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        bpackage.setBackground(Color.blue);
        bpackage.setBorderPainted(false);
        bpackage.setOpaque(true);
        bpackage.setForeground(Color.white);
        bpackage.addActionListener(this);
        add(bpackage);

        back = new JButton("Back");
        back.setBounds(730, 400, 130, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.BLUE);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(435, 50, 430, 350);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Tcheck) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from Hotelss where name ='" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int person = Integer.parseInt(Tperson.getText());
                    int days = Integer.parseInt(Tday.getText());
                    String acselected = cAc.getSelectedItem();
                    String foodselected = Food.getSelectedItem();

                    if (person * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * person * days;
                        JLabeltp.setText("Rs. " + total);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == bpackage) {

            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookHotels values('" + labelusername.getText() + "','"
                        + chotel.getSelectedItem() + "','"
                        + Tperson.getText()
                        + "','" + Tday.getText() + "','"
                        + cAc.getSelectedItem() + "','" + Food.getSelectedItem() + "','" + JLabelid.getText() + "','"
                        + JLabelnumber.getText() + "','"
                        + JLabeltp.getText() + "','" + JLabelphone.getText() + "')");

                JOptionPane.showMessageDialog(null, "Hotel Booked successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("");
    }
}
