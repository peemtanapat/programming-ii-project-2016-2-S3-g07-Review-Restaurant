package projectjava;

public class Review implements Comparable {

    private User user;
    private Store store;
    private Score score;
    private String content;
    private static int count;
    private static String orderBy = "name";

    public Review() {
    }
    
    public Review(User user, Store store, Score score, String content) {
        this.user = user;
        this.store = store;
        this.score = score;
        this.content = content;
        count++;
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
    public String getNameStore(){
        String temp = store.getStoreName().substring(0,1);
        return temp;
    }
    public int compareTo(Object obj) {
        int result = 0;
        if (obj != null && obj instanceof Review) {
            Review r = (Review) obj;
            if (orderBy.equalsIgnoreCase("numReview")) {

            } else if(orderBy.equalsIgnoreCase("score")) {
                result = r.getAvgScore()-this.getAvgScore();
            }else result = this.getNameStore().compareTo(r.getNameStore());
        }
        return result;
    }

    public void setDelete(String delete) {

        if (delete.equalsIgnoreCase("YES")) {
            this.content = null;
        } else if (delete.equalsIgnoreCase("NO")) {
            this.content = content;
        } else {
            this.content = "Please select YES / No";
        }

    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStoreName(Store store) {
        this.store = store;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String output = "\n-------OUTPUT-------\n"
                + "\nStore: " + store
                + "\n________________________________________________________________________________"
                + "\n" + user
                + "\n" + score
                + "\n" + content
                + "\n________________________________________________________________________________";
        return output;
    }
}
