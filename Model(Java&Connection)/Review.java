package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Review extends Score {

    private static int reviewId;
    private String resId;
    private String userName;
    private String topicReview;
    private String contentReview;
    private Score score;
    private static Date date = null;
    private static int count;
    private static String imageURL;

    public Review() {
    }

    public Review(String resId, String userName, String topicReview, String contentReview, Score score) {
        this.resId = resId;
        this.userName = userName;
        this.topicReview = topicReview;
        this.contentReview = contentReview;
        this.score = score;
    }

    public static Integer getNumRow() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT COUNT(*) AS NUMROWS FROM REVIEW");
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int numrows = rs.getInt("NUMROWS");
        return numrows;
    }

    public static Integer getAvgScore() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT (taste+clean+look+service+worth)/5 AS ScoreAVG FROM REVIEW"
                + "JOIN Restaurant ON Res_Id = Review_id");
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int scoreAVG = rs.getInt("ScoreAVG");
        return scoreAVG;
    }

    public static void reviewRes(String user, int resId, String top, String content,
            int taste, int clean, int service, int look, int worth, String imgUrl) throws SQLException, ClassNotFoundException {
        ArrayList<Review> review = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        int numRows = getNumRow();
        numRows = numRows + 1;
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "INSERT INTO Review VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";

        PreparedStatement pst = con.prepareStatement(sqlCmd);
        pst.setInt(1, numRows);
        pst.setString(2, user);
        pst.setInt(3, resId);
        pst.setString(4, top);
        pst.setString(5, content);
        pst.setInt(6, taste);
        pst.setInt(7, clean);
        pst.setInt(8, service);
        pst.setInt(9, look);
        pst.setInt(10, worth);
        pst.setString(11, imgUrl);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        pst.setDate(12, java.sql.Date.valueOf(sdf.format(date)));

        pst.executeUpdate();

    }

    public static java.sql.Date getCurrentDatetime() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static String selectImageURL(String reviewid) throws SQLException {
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT * FROM REVIEW WHERE review_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            int review_id = Integer.parseInt(reviewid);
            ps.setInt(1, review_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                imageURL = rs.getString("IMGURL");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());;
        }
        return imageURL;
    }

    public static double getAvgScoreFromDB(int res_id) {
        String sql = "SELECT (sum(taste+clean+service+look+worth)/count(res_id))/count(res_id) AS avgScore FROM REVIEW WHERE res_id=?";
        double result = 0.0;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, res_id);
            ResultSet rs = pst.executeQuery();
            result = rs.getDouble(1);
//            System.out.println(result);
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        } catch (SQLException ex) {
            System.out.println("");
        }
        return result;
    }

    private static Review orm(Review r, ResultSet rs) throws SQLException {
        //--------------Reviews table-----------------
        r.setReviewId(rs.getInt("res_id"));
        r.setTopicReview(rs.getString("topicReview"));
        r.setContentReview(rs.getString("contentReview "));
        r.setTaste(rs.getDouble("taste"));
        r.setClean(rs.getDouble("clean"));
        r.setService(rs.getDouble("service"));
        r.setLook(rs.getDouble("look"));
        r.setWorth(rs.getDouble("worth"));
        return r;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getResId() {
        return resId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTopicReview() {
        return topicReview;
    }

    public void setTopicReview(String topicReview) {
        this.topicReview = topicReview;
    }

    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    public static String getImageURL() {
        return imageURL;
    }

    public static void setImageURL(String urlpig) {
        Review.imageURL = imageURL;
    }

    public Score getScore() {
        return score;
    }

    public String getAllString() {
        return getReviewId() + " " + getUserName() + " " + getResId() + " " + getTopicReview() + ", " + getContentReview() + ", " + getScore();
    }

    @Override
    public String toString() {
        String output = "\n-------OUTPUT-------\n"
                //+ "\nStore: " + restaurant
                + "\n________________________________________________________________________________"
                + "\n" + userName
                + "\n" + score
                + "\n" + contentReview
                + "\n________________________________________________________________________________";
        return output;
    }
}
