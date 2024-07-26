package Tourism_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener {
        String Username;
        JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkpackage, Bookpackage,
                        viewpackage, viewHotels, destination, BookHotels, viewBookHotels, payments, Calculators,
                        deletePersonalDetails,
                        Notepad;

        Dashboard(String Username) {
                this.Username = Username;
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setLayout(null);

                JPanel p1 = new JPanel();
                p1.setLayout(null);
                p1.setBackground(new Color(0, 0, 102));
                p1.setBounds(0, 0, 1600, 65);
                add(p1);

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
                Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(5, 0, 70, 70);
                p1.add(image);

                JLabel heading = new JLabel("Dashbaord");
                heading.setFont(new Font("Tohoma", Font.BOLD, 30));
                heading.setBounds(80, 10, 300, 40);
                heading.setForeground(Color.white);
                p1.add(heading);

                JLabel text = new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM ");
                text.setBounds(450, 10, 1650, 40);
                text.setForeground(Color.white);
                text.setFont(new Font("Tohoma", Font.BOLD, 30));
                p1.add(text);

                JPanel p2 = new JPanel();
                p2.setLayout(null);
                p2.setBackground(new Color(0, 0, 102));
                p2.setBounds(0, 65, 300, 725);
                add(p2);

                addPersonalDetails = new JButton("Add Personal Details");
                addPersonalDetails.setBounds(0, 0, 300, 50);
                addPersonalDetails.setBackground(new Color(0, 0, 102));
                addPersonalDetails.setForeground(Color.white);
                addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
                addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
                addPersonalDetails.addActionListener(this);
                p2.add(addPersonalDetails);

                updatePersonalDetails = new JButton("Update Personal Details");
                updatePersonalDetails.setBounds(0, 45, 300, 50);
                updatePersonalDetails.setBackground(new Color(0, 0, 102));
                updatePersonalDetails.setForeground(Color.white);
                updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
                updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
                updatePersonalDetails.addActionListener(this);
                p2.add(updatePersonalDetails);

                viewPersonalDetails = new JButton("View Personal Details");
                viewPersonalDetails.setBounds(0, 90, 300, 50);
                viewPersonalDetails.setBackground(new Color(0, 0, 102));
                viewPersonalDetails.setForeground(Color.white);
                viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
                viewPersonalDetails.setMargin(new Insets(0, 0, 0, 50));
                viewPersonalDetails.addActionListener(this);
                p2.add(viewPersonalDetails);

                deletePersonalDetails = new JButton("Delete Personal Details");
                deletePersonalDetails.setBounds(0, 135, 300, 50);
                deletePersonalDetails.setBackground(new Color(0, 0, 102));
                deletePersonalDetails.setForeground(Color.white);
                deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
                deletePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
                deletePersonalDetails.addActionListener(this);
                p2.add(deletePersonalDetails);

                checkpackage = new JButton("Check Package  ");
                checkpackage.setBounds(0, 180, 300, 50);
                checkpackage.setBackground(new Color(0, 0, 102));
                checkpackage.setForeground(Color.white);
                checkpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
                checkpackage.setMargin(new Insets(0, 0, 0, 100));
                checkpackage.addActionListener(this);
                p2.add(checkpackage);

                Bookpackage = new JButton("Book Package  ");
                Bookpackage.setBounds(0, 225, 300, 50);
                Bookpackage.setBackground(new Color(0, 0, 102));
                Bookpackage.setForeground(Color.white);
                Bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
                Bookpackage.setMargin(new Insets(0, 0, 0, 110));
                Bookpackage.addActionListener(this);
                p2.add(Bookpackage);

                viewpackage = new JButton("View Package  ");
                viewpackage.setBounds(0, 270, 300, 50);
                viewpackage.setBackground(new Color(0, 0, 102));
                viewpackage.setForeground(Color.white);
                viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
                viewpackage.setMargin(new Insets(0, 0, 0, 110));
                viewpackage.addActionListener(this);
                p2.add(viewpackage);

                viewHotels = new JButton("View Hotel  ");
                viewHotels.setBounds(0, 315, 300, 50);
                viewHotels.setBackground(new Color(0, 0, 102));
                viewHotels.setForeground(Color.white);
                viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
                viewHotels.setMargin(new Insets(0, 0, 0, 130));
                viewHotels.addActionListener(this);
                p2.add(viewHotels);

                BookHotels = new JButton("Book Hotel  ");
                BookHotels.setBounds(0, 360, 300, 50);
                BookHotels.setBackground(new Color(0, 0, 102));
                BookHotels.setForeground(Color.white);
                BookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
                BookHotels.setMargin(new Insets(0, 0, 0, 130));
                BookHotels.addActionListener(this);
                p2.add(BookHotels);

                viewBookHotels = new JButton("View Book Hotel  ");
                viewBookHotels.setBounds(0, 405, 300, 50);
                viewBookHotels.setBackground(new Color(0, 0, 102));
                viewBookHotels.setForeground(Color.white);
                viewBookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
                viewBookHotels.setMargin(new Insets(0, 0, 0, 90));
                viewBookHotels.addActionListener(this);
                p2.add(viewBookHotels);

                destination = new JButton("Destination");
                destination.setBounds(0, 450, 300, 50);
                destination.setBackground(new Color(0, 0, 102));
                destination.setForeground(Color.white);
                destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
                destination.setMargin(new Insets(0, 0, 0, 140));
                destination.addActionListener(this);
                p2.add(destination);

                payments = new JButton("Payments ");
                payments.setBounds(0, 495, 300, 50);
                payments.setBackground(new Color(0, 0, 102));
                payments.setForeground(Color.white);
                payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
                payments.setMargin(new Insets(0, 0, 0, 155));
                payments.addActionListener(this);
                p2.add(payments);

                Calculators = new JButton("Calculators ");
                Calculators.setBounds(0, 540, 300, 50);
                Calculators.setBackground(new Color(0, 0, 102));
                Calculators.setForeground(Color.white);
                Calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
                Calculators.setMargin(new Insets(0, 0, 0, 145));
                Calculators.addActionListener(this);
                p2.add(Calculators);

                Notepad = new JButton("Notepad ");
                Notepad.setBounds(0, 585, 300, 50);
                Notepad.setBackground(new Color(0, 0, 102));
                Notepad.setForeground(Color.white);
                Notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
                Notepad.setMargin(new Insets(0, 0, 0, 155));
                Notepad.addActionListener(this);
                p2.add(Notepad);

                JButton about = new JButton("About ");
                about.setBounds(0, 630, 300, 50);
                about.setBackground(new Color(0, 0, 102));
                about.setForeground(Color.white);
                about.setFont(new Font("Tahoma", Font.PLAIN, 20));
                about.setMargin(new Insets(0, 0, 0, 170));
                p2.add(about);

                JButton Help = new JButton("Help ");
                Help.setBounds(0, 675, 300, 50);
                Help.setBackground(new Color(0, 0, 102));
                Help.setForeground(Color.white);
                Help.setFont(new Font("Tahoma", Font.PLAIN, 20));
                Help.setMargin(new Insets(0, 0, 0, 180));
                p2.add(Help);

                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
                Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JLabel imagLabel = new JLabel(i6);
                imagLabel.setBounds(0, 0, 1650, 1000);
                add(imagLabel);

                setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == addPersonalDetails) {
                        new AddCostomer(Username);
                } else if (ae.getSource() == viewPersonalDetails) {
                        new ViewCustomer(Username);
                } else if (ae.getSource() == updatePersonalDetails) {
                        new UpdateCustomer(Username);
                } else if (ae.getSource() == checkpackage) {
                        new CheckPackage();
                } else if (ae.getSource() == Bookpackage) {
                        new BookPackage(Username);
                } else if (ae.getSource() == viewpackage) {
                        new ViewPackage(Username);
                } else if (ae.getSource() == viewHotels) {
                        new CheckHotels();
                } else if (ae.getSource() == destination) {
                        new Destination();
                } else if (ae.getSource() == BookHotels) {
                        new BookHotel(Username);
                } else if (ae.getSource() == viewBookHotels) {
                        new ViewBookedHotel(Username);
                } else if (ae.getSource() == payments) {
                        new Payment();
                } else if (ae.getSource() == Calculators) {
                        try {
                                Runtime.getRuntime().exec("calc.exe");
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                } else if (ae.getSource() == Notepad) {
                        try {
                                Runtime.getRuntime().exec("notepad.exe");
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                } else if (ae.getSource() == deletePersonalDetails) {
                        new Delete(Username);
                        // setVisible(false);
                }
        }

        public static void main(String[] args) {
                new Dashboard("");
        }
}
