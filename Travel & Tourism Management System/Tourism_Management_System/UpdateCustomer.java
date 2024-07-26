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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfgender, tfnumber, tfid, tfcountry, tfaddress, tfphone, tfemail;
    JButton update, back;
    JLabel lableusername, lablename;
    String Username;

    UpdateCustomer(String Username) {
        this.Username = Username;

        setBounds(410, 100, 750, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 20, 400, 25);
        text.setFont(new Font("Ralay", Font.BOLD, 20));
        text.setForeground(Color.BLUE);
        add(text);

        JLabel T_username = new JLabel("Username :");
        T_username.setBounds(30, 70, 150, 25);
        T_username.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_username);

        lableusername = new JLabel();
        lableusername.setBounds(220, 70, 150, 25);
        lableusername.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lableusername);

        JLabel username_id = new JLabel("ID :");
        username_id.setBounds(30, 150, 150, 25);
        username_id.setFont(new Font("Ralay", Font.BOLD, 15));
        add(username_id);

        tfid = new JTextField();
        tfid.setBounds(220, 150, 150, 25);
        tfid.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfid);

        JLabel T_number = new JLabel("ID Number :");
        T_number.setBounds(30, 190, 150, 25);
        T_number.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_number);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 190, 150, 25);
        tfnumber.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfnumber);

        JLabel userName = new JLabel("Name :");
        userName.setBounds(30, 110, 150, 25);
        userName.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userName);

        lablename = new JLabel();
        lablename.setBounds(220, 110, 150, 25);
        lablename.setFont(new Font("Ralay", Font.BOLD, 15));
        add(lablename);

        JLabel usergender = new JLabel("Gender :");
        usergender.setBounds(30, 230, 150, 25);
        usergender.setFont(new Font("Ralay", Font.BOLD, 15));
        add(usergender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 230, 150, 25);
        tfgender.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfgender);

        JLabel userCountry = new JLabel("Country :");
        userCountry.setBounds(30, 270, 150, 25);
        userCountry.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userCountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 270, 150, 25);
        tfcountry.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfcountry);

        JLabel useraddres = new JLabel("Address :");
        useraddres.setBounds(30, 310, 150, 25);
        useraddres.setFont(new Font("Ralay", Font.BOLD, 15));
        add(useraddres);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 310, 150, 25);
        tfaddress.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfaddress);

        JLabel userphone = new JLabel("Mobile No :");
        userphone.setBounds(30, 350, 150, 25);
        userphone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 350, 150, 25);
        tfphone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfphone);

        JLabel useremail = new JLabel("Email Id :");
        useremail.setBounds(30, 390, 150, 25);
        useremail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(useremail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 390, 150, 25);
        tfemail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfemail);

        update = new JButton("Update");
        update.setBounds(70, 450, 100, 25);
        update.setBackground(Color.blue);
        update.setBorderPainted(false);
        update.setOpaque(true);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(220, 450, 100, 25);
        back.setBackground(Color.blue);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 40, 400, 450);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customerss where Username = '" + Username + "'");
            while (rs.next()) {
                lableusername.setText(rs.getString("Username"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                lablename.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }

        } catch (Exception e) {

        }

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String Username = lableusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = lablename.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "update  customerss set Username= '" + Username + "', id='" + id + "' ,number= '"
                        + number
                        + "', name='" + name + "',gender= '" + gender + "',country='" + country + "',address='"
                        + address + "',phone='"
                        + phone + "',email='" + email + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Succesfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer(" ");
    }
}
