package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar baar;
    String Username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = baar.getMaximum();
                int value = baar.getValue();
                if (value < max) {
                    baar.setValue(baar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(Username);
                }
                Thread.sleep(50);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String Username) {
        this.Username = Username;
        t = new Thread(this);
        setBounds(320, 150, 700, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 1600, 1000);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/done.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 450);
        p1.add(image);

        JLabel text = new JLabel("Travel And Tourism Application");
        text.setBackground(Color.red);

        text.setBounds(95, 20, 600, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        image.add(text);

        baar = new JProgressBar();
        baar.setBounds(200, 100, 300, 50);
        baar.setStringPainted(true);
        image.add(baar);

        JLabel Loading = new JLabel("Loading Please Wait..");
        Loading.setFont(new Font("Tohoma", Font.BOLD, 18));
        Loading.setBounds(360, 150, 200, 30);
        Loading.setForeground(Color.red);
        image.add(Loading);

        JLabel username = new JLabel("Welcome "+ Username);
        username.setFont(new Font("Tohoma", Font.BOLD, 20));
        username.setBounds(20, 350, 500, 50);
        username.setForeground(Color.red);
        image.add(username);
        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
