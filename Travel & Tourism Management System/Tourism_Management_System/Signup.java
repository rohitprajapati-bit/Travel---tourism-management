package Tourism_Management_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton Create, Back;
    JTextField T_username, T_Name, T_Password, T_Answer;
    Choice Security;
    JLabel text;

    Signup() {
        setBounds(220, 200, 900, 350);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        add(p1);
        p1.setLayout(null);

        JLabel Travel_username = new JLabel("Username");
        Travel_username.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_username.setBounds(50, 20, 125, 25);
        p1.add(Travel_username);

        T_username = new JTextField();
        T_username.setBounds(190, 20, 180, 25);
        T_username.setBorder(BorderFactory.createEmptyBorder());
        T_username.setFont(new Font("Tohoma", Font.BOLD, 13));
        p1.add(T_username);

        JLabel Travel_Name = new JLabel("Name");
        Travel_Name.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Name.setBounds(50, 60, 125, 25);
        p1.add(Travel_Name);

        T_Name = new JTextField();
        T_Name.setBounds(190, 60, 180, 25);
        T_Name.setBorder(BorderFactory.createEmptyBorder());
        T_Name.setFont(new Font("Tohoma", Font.BOLD, 13));
        p1.add(T_Name);

        JLabel Travel_Password = new JLabel("Password");
        Travel_Password.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Password.setBounds(50, 100, 125, 25);
        p1.add(Travel_Password);

        T_Password = new JPasswordField();
        T_Password.setBounds(190, 100, 180, 25);
        T_Password.setBorder(BorderFactory.createEmptyBorder());
        T_Password.setFont(new Font("Tohoma", Font.BOLD, 13));
        p1.add(T_Password);

        JLabel Travel_Security = new JLabel("Security Question");
        Travel_Security.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Security.setBounds(50, 140, 125, 25);
        p1.add(Travel_Security);

        Security = new Choice();
        Security.add("Your Childhood Friend? ");
        Security.add("What is your favorite vacation destination?");
        Security.add("In which year did you graduate from high school?");
        Security.add("Your Luck Number?");
        Security.setBounds(185, 140, 190, 25);
        Security.setFont(new Font("Tohoma", Font.BOLD, 13));
        p1.add(Security);

        JLabel Travel_Answer = new JLabel("Answer");
        Travel_Answer.setFont(new Font("Tohoma", Font.BOLD, 14));
        Travel_Answer.setBounds(50, 180, 125, 25);
        p1.add(Travel_Answer);

        T_Answer = new JTextField();
        T_Answer.setBounds(190, 180, 180, 25);
        T_Answer.setBorder(BorderFactory.createEmptyBorder());
        T_Answer.setFont(new Font("Tohoma", Font.BOLD, 13));
        p1.add(T_Answer);

        Create = new JButton("Create");
        Create.setBackground(Color.white);
        Create.setForeground(new Color(133, 193, 233));
        Create.setFont(new Font("Tohoma", Font.BOLD, 14));
        Create.setBounds(80, 250, 100, 30);
        Create.addActionListener(this);
        p1.add(Create);

        Back = new JButton("Back");
        Back.setBackground(Color.white);
        Back.setForeground(new Color(133, 193, 233));
        Back.setFont(new Font("Tohoma", Font.BOLD, 14));
        Back.setBounds(250, 250, 100, 30);
        Back.addActionListener(this);
        p1.add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        JLabel text = new JLabel("Sign up ");
        text.setBounds(640, 5, 400, 60);
        text.setFont(new Font("Ralay", Font.BOLD, 30));
        add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Create) {
            String Username = T_username.getText();
            String name = T_Name.getText();
            String password = T_Password.getText();
            String question = Security.getSelectedItem();
            String ans = T_Answer.getText();

            String query = "insert into account values ('" + Username + "','" + name + "','" + password + "','"
                    + question + "','" + ans + "' )";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Succssefully");
                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == Back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
