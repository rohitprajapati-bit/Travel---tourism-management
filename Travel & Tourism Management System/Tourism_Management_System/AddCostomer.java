package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;

public class AddCostomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnumber, tfaddress, tfcountry, tfphone, tfEmail;
    JRadioButton tmale, tfemale;
    JLabel labelusername;
    JLabel labelname, text;
    JButton add, back;
    String Username;

    AddCostomer(String Username) {
        this.Username = Username;

        setBounds(410, 100, 750, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("ADD CUSTOMER DETAILS");
        text.setBounds(50, 2, 400, 25);
        text.setFont(new Font("Ralay", Font.BOLD, 20));
        text.setForeground(Color.blue);
        add(text);

        JLabel T_username = new JLabel("Username : ");
        T_username.setBounds(30, 50, 150, 25);
        T_username.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_username);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelusername);

        JLabel username_id = new JLabel("ID : ");
        username_id.setBounds(30, 130, 150, 25);
        username_id.setFont(new Font("Ralay", Font.BOLD, 15));
        add(username_id);

        comboid = new JComboBox(new String[] { "Passport", "Pan Card", "Aadhar Card" });
        comboid.setBounds(220, 130, 150, 25);
        comboid.setFont(new Font("Ralay", Font.BOLD, 15));
        add(comboid);

        JLabel T_number = new JLabel("ID Number : ");
        T_number.setBounds(30, 170, 150, 25);
        T_number.setFont(new Font("Ralay", Font.BOLD, 15));
        add(T_number);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 170, 150, 25);
        tfnumber.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfnumber);

        JLabel userName = new JLabel("Name : ");
        userName.setBounds(30, 90, 150, 25);
        userName.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userName);

        labelname = new JLabel();
        labelname.setBounds(220, 90, 150, 25);
        labelname.setFont(new Font("Ralay", Font.BOLD, 15));
        add(labelname);

        JLabel usergender = new JLabel("Gender : ");
        usergender.setBounds(30, 210, 150, 25);
        usergender.setFont(new Font("Ralay", Font.BOLD, 15));
        add(usergender);

        tmale = new JRadioButton("Male");
        tmale.setBounds(220, 210, 70, 25);
        tmale.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tmale);

        tfemale = new JRadioButton("Female");
        tfemale.setBounds(300, 210, 80, 25);
        tfemale.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(tmale);
        bg.add(tfemale);

        JLabel useraddres = new JLabel("Address : ");
        useraddres.setBounds(30, 290, 150, 25);
        useraddres.setFont(new Font("Ralay", Font.BOLD, 15));
        add(useraddres);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        tfaddress.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfaddress);

        JLabel usercountry = new JLabel("Country : ");
        usercountry.setBounds(30, 250, 150, 25);
        usercountry.setFont(new Font("Ralay", Font.BOLD, 15));
        add(usercountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        tfcountry.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfcountry);

        JLabel userphone = new JLabel("Mobail No : ");
        userphone.setBounds(30, 330, 150, 25);
        userphone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        tfphone.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfphone);

        JLabel userEmail = new JLabel("Email Id : ");
        userEmail.setBounds(30, 370, 150, 25);
        userEmail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(userEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        tfEmail.setFont(new Font("Ralay", Font.BOLD, 15));
        add(tfEmail);

        add = new JButton("Add");
        add.setBounds(70, 430, 76, 25);
        add.setBackground(Color.black);
        add.setOpaque(true);
        add.setBorderPainted(false);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220, 430, 76, 25);
        back.setBackground(Color.black);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 40, 400, 420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where Username = '" + Username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String Username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (tmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfEmail.getText();

            try {
                Conn c = new Conn();
                String query = "insert into customerss values ('" + Username + "', '" + id + "' , '" + number + "','"
                        + name
                        + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Succesfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCostomer(" ");

    }
}
