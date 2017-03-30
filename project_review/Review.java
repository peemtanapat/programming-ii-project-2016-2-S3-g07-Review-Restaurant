package project_review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Review extends Score implements Comparable {

    private static int reviewId=1000;
    private User user;
    private String topicReview;
    //private Restaurant restaurant;
    private String contentReview;
    private Score score;
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
  private static Review orm(Review r, ResultSet rs) throws SQLException {
        //--------------Reviews table-----------------
        r.setReviewId(rs.getInt("res_id"));
        r.setTopicReview(rs.getString("topicReview"));
        r.setContentReview (rs.getString("contentReview "));
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
