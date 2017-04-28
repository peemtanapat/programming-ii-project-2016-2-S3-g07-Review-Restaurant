package project_review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

    protected int userId;
    protected String username;
    private String password;
    private String FName;
    private String LName;
    private int reviewId;
    private int resId;

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
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.close();
        }
    }

    public static ArrayList LogInTest(String username, String password) throws ClassNotFoundException, SQLException {
        ArrayList<User> us = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement stmU;

        String sqlU = "SELECT * FROM USERS WHERE username=? AND password=?";
        stmU = con.prepareStatement(sqlU);
        stmU.setString(1, username);
        stmU.setString(2, password);

        ResultSet rs = stmU.executeQuery();
        while (rs.next()) {
            User user = new User();
            orm(user, rs);
            us.add(user);
        }
        return us;
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
//        stm.setString(4, FName);
//        stm.setString(5, LName);
//        ResultSet rs = 
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
//        u.setFName(rs.getString("firstName"));
//        u.setLName(rs.getString("lastName"));

        return u;

    }

    public String printAllUser() {
        String output = getUserId() + " " + getUsername() + " " + getPassword();
        return output;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String toString() {
        return "By: " + username;
    }
}
