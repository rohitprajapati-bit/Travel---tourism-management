package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton login, password, signup;
    JTextField T_username;
    JTextField T_Password;
    JLabel text;

    Login() {
        setSize(900, 400);
        setLocation(210, 180);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        final JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 470, 320);
        add(p2);

        JLabel text = new JLabel(" Login ");
        text.setBounds(155, 25, 400, 50);
        text.setFont(new Font("Ralay", Font.BOLD, 30));
        p1.add(text);

        JLabel Travel_username = new JLabel("Username");
        Travel_username.setBounds(60, 20, 100, 25);
        Travel_username.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(Travel_username);

        T_username = new JTextField();
        T_username.setBounds(60, 60, 300, 30);
        T_username.setFont(new Font("Ralay", Font.BOLD, 15));
        p2.add(T_username);

        JLabel Travel_Password = new JLabel("Password");
        Travel_Password.setBounds(60, 110, 100, 25);
        Travel_Password.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(Travel_Password);

        T_Password = new JTextField();
        T_Password.setBounds(60, 150, 300, 30);
        T_Password.setFont(new Font("Ralay", Font.BOLD, 15));
        p2.add(T_Password);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.black);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setFont(new Font("Ralay", Font.BOLD, 15));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setFont(new Font("Ralay", Font.BOLD, 15));
        signup.setForeground(Color.black);
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(150, 250, 130, 30);
        password.setForeground(Color.red);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setFont(new Font("Ralay", Font.BOLD, 15));
        password.addActionListener(this);
        p2.add(password);

        JLabel tex = new JLabel("Trouble in login...");
        tex.setBounds(350, 280, 150, 20);
        tex.setFont(new Font("Ralay", Font.BOLD, 15));
        tex.setForeground(Color.RED);
        p2.add(tex);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String Username = T_username.getText();
                 String password = T_Password.getText();

                String query = "select * from account where username ='" + Username + "' AND password = '" + password
                        + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(Username);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username Or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();

        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

    public String toString() {
        return "Login []";
    }
}
