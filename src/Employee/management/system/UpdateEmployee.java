package Employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {
    JButton add, back;

    JTextField tfeducation, tffname, tfadd, tfadhar, tfemail, tfphone, tfsalary, tfdesignation;

    JLabel lblempid;
    String empid;

    UpdateEmployee(String empid) {
        this.empid = empid;

        getContentPane().setBackground(Color.white);  // full frame colour change
        setLayout(null);
        // heading
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        add(heading);
// Label for Name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        // Text field
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);


        // Text field
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel Labeladd = new JLabel("Address");
        Labeladd.setBounds(50, 250, 150, 30);
        Labeladd.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labeladd);
        tfadd = new JTextField();
        tfadd.setBounds(200, 250, 150, 30);
        add(tfadd);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        // Text field
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Higher Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel labeladhar = new JLabel("Adhar");
        labeladhar.setBounds(400, 350, 150, 30);
        labeladhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladhar);
        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600, 350, 150, 30);
        add(lbladhar);

        JLabel labelempid = new JLabel("Employee id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
        lblempid = new JLabel();
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        try {
            Conn c = new Conn();
            String query = "select * from employee where empid = '" + empid + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfadd.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lbladhar.setText(rs.getString("adhar"));
                lblempid.setText(rs.getString("empid"));
                tfdesignation.setText(rs.getString("designation"));

            }


        } catch (Exception o) {
            o.printStackTrace();
            ;
        }

        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // find the value of alls from add Employee Class  no changes
        if (e.getSource() == add) {
            // String name = tfname.getText();
            String fname = tffname.getText();
            // String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();        no changes
            String salary = tfsalary.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            // String adhar = tfadhar.getText();     no changes
           // String  empid = lblempid.getText();


            try {
                Conn conn = new Conn();
                // insert is a Dml command
                String query = "update employee set fname = '"+fname+"',salary='"+salary+ "',address='" +address+"',phone ='" + phone + "',email = '" + email + "',education ='" + education + "',designation= '" + designation + "'where empid='" + empid + "'";
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details add Successful");
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

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}