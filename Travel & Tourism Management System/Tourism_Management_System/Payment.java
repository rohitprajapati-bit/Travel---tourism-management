package Tourism_Management_System;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;

    Payment() {
        // setBounds(370, 100, 850, 600);
        setBounds(390, 100, 800, 550);
        getContentPane().setBackground(Color.white);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 580, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(30, 400, 80, 25);
        pay.addActionListener(this);
        pay.setBackground(Color.BLACK);
        pay.setBorderPainted(false);
        pay.setOpaque(true);
        pay.setForeground(Color.white);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(680, 400, 80, 25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        image.add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            setVisible(false);
            new paytm();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
