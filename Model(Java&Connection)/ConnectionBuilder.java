package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author INT303
 */
public class ConnectionBuilder {

//    private static org.apache.derby.jdbc.ClientDataSource ds = null;

    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ReviewDBRoot","app","app");
        } catch (SQLException ex) {
            System.out.println("ConnectionBuilder 2 "+ex);
        }
        return con;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        getConnection();
    }
}
