package TEST2;

public class Review{

    private String foodName;
    private double foodPrice;
    private String storeName;
    private String storeLocation;
    private String reviewContent;
    private String userName;
    private int userID;
    private static int count;

    public Review(String foodName, double foodPrice, String storeName, String storeLocation, String reviewContent, String userName, int userID) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.reviewContent = reviewContent;
        this.userName = userName;
        this.userID = userID;
    }

   

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String result
                = //"Review by: " + userName
                "ชื่ออาหาร: " + foodName
                + "\nรีวิวโดย: " + userName
                + "\nID: " + userID
                + "\nราคา: " + foodPrice
                + "\nร้านอาหาร: " + storeName
                + "\nที่อยู่: " + storeLocation
                + "\nเนื้อหารีวิว: " + reviewContent;
        return result;
    }
}
