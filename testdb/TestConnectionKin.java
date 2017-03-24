/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                c = rs.getString("fname");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
        System.out.println(c);
    }
    
}
