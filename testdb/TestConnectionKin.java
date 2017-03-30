
package testdb;

import project_review.ConnectionBuilder;
import java.sql.*;
import java.util.*;

public class TestConnectionKin {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        String c = null;
        int id = 10;
        Connection con = ConnectionBuilder.getConnection();
        String sqlCmd = "select  * from instantfoods where fid = ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt (1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next ()) {
            try {
                c = rs.getString("firstName");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
        System.out.println(c);
    }
    
}
