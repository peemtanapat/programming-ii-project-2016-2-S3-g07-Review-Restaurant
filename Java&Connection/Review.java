package project_review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Review extends Score{

    private static int reviewId = 1000;
    private String resId;
    private String userName;
    private String topicReview;
    private String contentReview;
    private Score score;
    private static Date date;
    private static int count;
    private static String orderBy = "name";
//    private User user;
//    private Restaurant restaurant;
    
    public Review() {
    }

//    public Review(User user, String contentReview, Score score) {
//        this.user = user;
//        this.contentReview = contentReview;
//        this.score = score;
//    }

    public Review(String resId, String userName, String topicReview, String contentReview, Score score) {
        this.resId = resId;
        this.userName = userName;
        this.topicReview = topicReview;
        this.contentReview = contentReview;
        this.score = score;
    }
    


    public String getAllString() {
        return getReviewId() + " " + getUserName() + " " + getResId() + " " + getTopicReview() + ", " + getContentReview() + ", " + getScore() + ", " + getDate();
    }
    
    public static Integer getNumRow() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT COUNT(*) AS NUMROWS FROM REVIEW");
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int numrows = rs.getInt("NUMROWS");
        return numrows;
    }

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        System.out.println(getNumRow());
//    }
    
    public static ArrayList reviewRes(String user, int resId, String top, String content, 
            int taste, int clean, int service, int look, int worth) throws SQLException, ClassNotFoundException {
        ArrayList<Review> review = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        int numRows = getNumRow();
        numRows=numRows+1;         
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "INSERT INTO Review VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1, numRows);
        stm.setString(2, user);
        stm.setInt(3, resId);
        stm.setString(4, top);
        stm.setString(5, content);
        stm.setInt(6, taste);
        stm.setInt(7, clean);
        stm.setInt(8, service);
        stm.setInt(9, look);
        stm.setInt(10, worth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        stm.setDate(11, java.sql.Date.valueOf(sdf.format(date)));
 
        stm.executeUpdate();
   
        return review;
    }

    public static java.sql.Date getCurrentDatetime() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }
    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    public Date getDate() {
        return date;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Review.count = count;
    }

    public Score getScore() {
        return score;
    }

    public static void setOrderBy(String orderBy) {
        Review.orderBy = orderBy;
    }

    public static String getOrderBy() {
        return orderBy;
    }

    public int getAvgScore() {
        int temp = (int) (getScore().getAvg() * 10);
        return temp;
    }

//    public String getNameStore() {
//        String temp = restaurant.getResName().substring(0, 1);
//        return temp;
//    }
//    public int compareTo(Object obj) {
//        int result = 0;
//        if (obj != null && obj instanceof Review) {
//            Review r = (Review) obj;
//            if (orderBy.equalsIgnoreCase("numReview")) {
//
//            } else if (orderBy.equalsIgnoreCase("score")) {
//                result = r.getAvgScore() - this.getAvgScore();
//            }
//                else {
//                result = this.getNameStore().compareTo(r.getNameStore());
//            }
//        }
//        return result;
//    }
//
//    public void setDelete(String delete) {
//
//        if (delete.equalsIgnoreCase("YES")) {
//            this.contentReview = null;
//        } else if (delete.equalsIgnoreCase("NO")) {
//            this.contentReview = contentReview;
//        } else {
//            this.contentReview = "Please select YES / No";
//        }
//
//    }

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
