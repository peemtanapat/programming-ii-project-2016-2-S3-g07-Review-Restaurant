package project_review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionBuilder2 {

    private static org.apache.derby.jdbc.ClientDataSource ds = null;

    public static Connection getConnection() throws ClassNotFoundException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ReviewDBII", "", "");
        } catch (SQLException ex) {
            System.out.println("2 "+ex);
        }
        return con;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        getConnection();
    }
}
