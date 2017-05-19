package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

    private static int userId;
    private static String username;
    private static String password;
    private static String userType;

    public User() {
    }

    public User(String userName) {
        this.username = userName;
    }

    public static int getNumRows() throws ClassNotFoundException, SQLException {
        int rows = 0;
        Connection con = ConnectionBuilder.getConnection();
        String sql = "SELECT COUNT(*) AS NUMROWS FROM USERS";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        rs.next();
        rows = rs.getInt("NUMROWS");
        return rows;
    }

    public void LogIn(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement stmU;
        try {
            String sqlU = "SELECT * FROM USERS WHERE username=? AND password=?";
            stmU = con.prepareStatement(sqlU);
            stmU.setString(1, username);
            stmU.setString(2, password);

            ResultSet rs = stmU.executeQuery();
            while (rs.next()) {
                orm(this, rs);
            }
            this.username=username;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.close();
        }
    }


    public static void Register(String username, String password) throws ClassNotFoundException, SQLException {
        int rows = getNumRows();
        rows++;
        Connection con = ConnectionBuilder.getConnection();
//      Statement stm = con.createStatement();
        String sql = "INSERT INTO Users VALUES (?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, rows);
        stm.setString(2, username);
        stm.setString(3, password);
        stm.setString(4, "user");

        try {
            stm.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("An account already exists with this Username.");
        }
    }

    public static User orm(User u, ResultSet rs) throws SQLException {

        u.setUserId(rs.getInt("User_id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setUserType(rs.getString("usertype"));
        return u;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        User.userId = userId;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        User.userType = userType;
    }

    public String printAllUser() {
        String output = getUserId() + " " + getUsername() + " " + getPassword();
        return output;
    }

    public String toString() {
        return "By: " + username;
    }

}
