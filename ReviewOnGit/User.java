package project_review;

public class User {
        
    private String userId;
    private String userName;
    private String pass;
    private String firstName;
    private String lastName;
    private int reviewId;
    private int resId;

    public User() {
    }
    
    public User(String userName) {
        this.userName = userName;
    }

    public User(String userId, String userName, String pass, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String toString() {
        return "By: " + userName;
    }
}
