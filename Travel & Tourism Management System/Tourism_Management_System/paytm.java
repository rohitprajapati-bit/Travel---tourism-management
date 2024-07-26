package Tourism_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class paytm extends JFrame implements ActionListener {
    JButton back;
    JLabel payment;

    paytm() {
        // setBounds(370, 100, 850, 600);
        setBounds(390, 100, 800, 550);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try {
            pane.setPage("https://paytm.com/online-payment");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html");
        }
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton(" BACK ");
        back.setBounds(650, 100, 100, 30);
        back.setBackground(Color.DARK_GRAY);
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setForeground(Color.white);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();

    }

    public static void main(String[] args) {
        new paytm();
    }
}
