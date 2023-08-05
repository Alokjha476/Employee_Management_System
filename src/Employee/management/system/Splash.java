package Employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // it is an interface which is overridden from parent class

public class Splash extends JFrame implements ActionListener {
    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // Headline
        JLabel headline = new JLabel("Employee Management System");
        add(headline);
        headline.setBounds(80, 30, 1200, 60);
        headline.setFont(new Font("serif", Font.PLAIN, 50));
        headline.setForeground(Color.red);
        // image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // convert image icon
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        // Set Button
        JButton clickhere = new JButton("Click here to continue");
        image.add(clickhere);
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.lightGray);
        clickhere.setForeground(Color.red);
        clickhere.addActionListener(this);

        setSize(1179, 650);
        setLocation(200, 50);
        setVisible(true);
        while (true) {
            headline.setVisible(false);
            try {
                Thread.sleep(400);
            } catch (Exception o) {

            }
            headline.setVisible(true);
            try {
                Thread.sleep(400);
            } catch (Exception o) {

            }
        }
    }
    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Conn();
       new Login();
    }
}
