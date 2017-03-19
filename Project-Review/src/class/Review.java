package projectjava;

public class Review {

    private User user;
    private Store store;
    private Score score;
    private String content;
    private static int count;

    public Review() {
    }

    public Review(User user, Store store, Score score, String content) {
        this.user = user;
        this.store = store;
        this.score = score;
        this.content = content;
        count++;
    }
    public void setDelete(String delete){

        if(delete.equalsIgnoreCase("YES")){
            this.content = null;
        }else if(delete.equalsIgnoreCase("NO")){
            this.content = content;
        }else
            this.content = "Please select YES / No";
        
        
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
