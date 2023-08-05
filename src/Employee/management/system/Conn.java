package Employee.management.system;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {
    Statement s;
    public Conn() {
        Connection c;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating the connecting string
            // DDl command
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root", "root");
            // create statement
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
