package project_review;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Review extends Score implements Comparable {

    private static int reviewId = 1000;
    private String resId;
    private User user;
    private String userName;
    private String topicReview;
    //private Restaurant restaurant;
    private String contentReview;
    private Score score;
    private Date date;
    private static int count;
    private static String orderBy = "name";

    public Review() {
    }

    public Review(User user, String contentReview, Score score) {
        this.user = user;
        this.contentReview = contentReview;
        this.score = score;
    }

//    public Review(User user, Restaurant store, Score score, String contentReview) {
//        this.user = user;
//        this.restaurant = store;
//        this.score = score;
//        this.contentReview = contentReview;
//        count++;
//    }
    public String getAllString() {
        return getReviewId() + " " + getUserName() + " " + getResId() + " " + getTopicReview() + ", " + getContentReview() + ", " + getScore() + ", " + getDate();
    }

    public static ArrayList reviewRes(int reId, String user, int resId, String top, String content, int taste, int clean, int service, int look, int worth,Date date) throws SQLException, ClassNotFoundException {
        ArrayList<Review> review = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "INSERT INTO Review VALUES (?,'?',?,'?','?',?,?,?,?,?,?) ";
//1        review_id numeric (10),
//2        username varchar (20),
//3        res_id numeric (6),
//4        topicReview varchar(100),
//5        contentReview varchar (500),
//6       taste numeric (1),
//7        clean numeric (1),
//8        service numeric (1),
//9        look numeric (1),
//10        worth numeric (1),
//        reviewDate date,
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1, reId);
        stm.setString(2, user);
        stm.setInt(3, resId);
        stm.setString(4, top);
        stm.setString(5, content);
        stm.setInt(6, taste);
        stm.setInt(7, clean);
        stm.setInt(8, service);
        stm.setInt(9, look);
        stm.setInt(10, worth);
//        java.sql.Date date = getCurrentDatetime();
//        stm.setDate(11, 2017-04-06);
        stm.setDate(11, date);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Review rev = new Review();
            Review.orm(rev, rs);
            review.add(rev);
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
    public int compareTo(Object obj) {
        int result = 0;
        if (obj != null && obj instanceof Review) {
            Review r = (Review) obj;
            if (orderBy.equalsIgnoreCase("numReview")) {

            } else if (orderBy.equalsIgnoreCase("score")) {
                result = r.getAvgScore() - this.getAvgScore();
            }
//                else {
//                result = this.getNameStore().compareTo(r.getNameStore());
//            }
        }
        return result;
    }
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
                + "\n" + user
                + "\n" + score
                + "\n" + contentReview
                + "\n________________________________________________________________________________";
        return output;
    }
}
