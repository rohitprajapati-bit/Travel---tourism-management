package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField T_username, T_Name, T_security, T_ans, T_Password;
    JButton search, retrieve, back;

    ForgetPassword() {
        setBounds(250, 170, 840, 430);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgetpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 100, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 55, 500, 300);
        add(p1);

        JLabel text = new JLabel(" FORGET PASSWORD ");
        text.setBounds(90, 0, 400, 50);
        text.setFont(new Font("Tohoma", Font.BOLD, 30));
        text.setForeground(Color.blue);
        add(text);

        JLabel b_use = new JLabel("Username");
        b_use.setFont(new Font("Tohoma", Font.BOLD, 14));
        b_use.setBounds(40, 20, 125, 25);
        p1.add(b_use);

        T_username = new JTextField();
        T_username.setBounds(190, 20, 150, 25);
        T_username.setBorder(BorderFactory.createEmptyBorder());
        p1.add(T_username);

        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setBorderPainted(false);
        search.setOpaque(true);
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel Travel_Name = new JLabel("Name");
        Travel_Name.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Name.setBounds(40, 60, 125, 25);
        p1.add(Travel_Name);

        T_Name = new JTextField();
        T_Name.setBounds(190, 60, 150, 25);
        T_Name.setBorder(BorderFactory.createEmptyBorder());
        p1.add(T_Name);

        JLabel Travel_security = new JLabel("Security Question");
        Travel_security.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_security.setBounds(40, 100, 125, 25);
        p1.add(Travel_security);

        T_security = new JTextField();
        T_security.setBounds(190, 100, 150, 25);
        T_security.setBorder(BorderFactory.createEmptyBorder());
        p1.add(T_security);

        JLabel Travel_ans = new JLabel("Answer");
        Travel_ans.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_ans.setBounds(40, 140, 125, 25);
        p1.add(Travel_ans);

        T_ans = new JTextField();
        T_ans.setBounds(190, 140, 150, 25);
        T_ans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(T_ans);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setBorderPainted(false);
        retrieve.setOpaque(true);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel Travel_Password = new JLabel("Password");
        Travel_Password.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Password.setBounds(40, 180, 125, 25);
        p1.add(Travel_Password);

        T_Password = new JTextField();
        T_Password.setBounds(190, 180, 150, 25);
        T_Password.setBorder(BorderFactory.createEmptyBorder());
        T_Password.addActionListener(this);
        p1.add(T_Password);

        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.setBounds(120, 240, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                String query = "select *from account where Username = '" + T_username.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    T_Name.setText(rs.getString("name"));
                    T_security.setText(rs.getString("Security"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == retrieve) {
            try {
                String query = "select *from account where ans = '" + T_ans.getText() + "' AND username = '"
                        + T_username.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    T_Password.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Answer");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
