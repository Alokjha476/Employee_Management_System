package Employee.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JButton search, print, update, back;
    JTable table;
    Choice employeeId;

    ViewEmployee() {

        getContentPane().setBackground(Color.white);  // full frame colour change
        setLayout(null);
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        employeeId = new Choice();
        employeeId.setBounds(180, 20, 150, 20);
        add(employeeId);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Employee");
            while (rs.next()) {
                employeeId.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();

        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== search){
            String query = "select * from employee where empid = '"+employeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception o){
                o.printStackTrace();
            }
        } else if (e.getSource()== print) {
            try {
                table.print();

            }catch (Exception o){
                o.printStackTrace();
            }


        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateEmployee(employeeId.getSelectedItem());


        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }
}
