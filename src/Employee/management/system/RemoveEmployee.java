package Employee.management.system;

import sun.awt.EmbeddedFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cEmpid;
    JButton back, delete;


    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel labelempid = new JLabel("Emp Id");
        labelempid.setBounds(50, 50, 100, 30);
        add(labelempid);
        cEmpid = new Choice();
        cEmpid.setBounds(200, 50, 150, 30);
        add(cEmpid);
        try {
            Conn conn = new Conn();
            String query = "select * from employee";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                cEmpid.add(rs.getString("empid"));
            }
        } catch (Exception o) {
            o.printStackTrace();

        }
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);

        try {
            Conn conn = new Conn();
            String query = "select * from employee where empid = '" + cEmpid.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception o) {
            o.printStackTrace();

        }
        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from employee where empid = '" + cEmpid.getSelectedItem() + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception o) {
                    o.printStackTrace();

                }
            }
        });
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(250, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // convert image icon
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);


        setSize(1000, 400);
        setLocation(300, 150);
        add(image);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveEmployee();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                Conn conn = new Conn();
                String query = "delete from employee where empid  ='" + cEmpid.getSelectedItem() + "' ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee information delete successfully");
                setVisible(false);
                new Home();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();

        }


    }
}
