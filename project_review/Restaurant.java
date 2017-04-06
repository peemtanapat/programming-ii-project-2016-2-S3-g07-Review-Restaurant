package project_review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Restaurant extends User implements Comparable {

    private static int resId=0;
    private String userId;
    private String resName; //ชื่อร้าน
    private String resType; //ประเภทของร้าน ex. buffet restaurant pub bar
    private String resTel; //เบอร์โทร
    private String resTime; //เวลาปิด-เปิดร้าน ex. 18.00 - 22.00
    private Location location;
    private User user;
    private Review[] review;
    private static String orderBy = "name";
    private static int count = 0;
//เพิ่มตัวแปร
    private String nameAdd; //ชื่อที่อยู่หลัก เช่น central plaza Rama II
    private String noRes; //เลขที่บ้าน
    private String road; //ถนน
    private String subDistrict; //ตำบล/แขวง
    private String district; //อำเภอ/เขต
    private String province; //จังหวัด
    private int postCode; //เลขไปรษณีย์

    public Restaurant() {
    }

    public Restaurant(int resId, String resName, String resType, String resTel, String resTime, Location location, Review[] review) {
        this.resId = resId;
        this.resName = resName;
        this.resType = resType;
        this.resTel = resTel;
        this.resTime = resTime;
        this.location = location;
        this.review = review;
        count++;
    }
    public static ArrayList review
        (int resId,String userName,String resName,String resType
                ,String resAdd,String resNo,String road,String subDistrict,String district,String province
                ,int postCode,String resTel,String resTime) 
                throws ClassNotFoundException, SQLException{
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder2.getConnection();
        String sqlCmd = "INSERT INTO Review VALUES (?,'?','?','?','?','?','?','?','?','?',?,'?','?')";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1, resId);
        stm.setString(2, userName); 
//        r.setResName(rs.getString("resName"));
//        r.setResType(rs.getString("resType"));
//        r.setResTel(rs.getString("resTel"));
//        r.setResTime(rs.getString("resTime"));
//        //--------------Location-------------------
//        r.setNameAdd(rs.getString("resAdd"));
//        r.setNoRes(rs.getString("resNo"));
//        r.setRoad(rs.getString("road"));
//        r.setSubDistrict(rs.getString("subDistrict"));
//        r.setDistrict(rs.getString("district"));
//        r.setProvince(rs.getString("province"));
//        r.setPostCode(rs.getInt("postCode"));
        stm.setString(3, resName);
        stm.setString(4, resType);
        stm.setString(5, resAdd);
        stm.setString(6, resNo);
        stm.setString(7, road);
        stm.setString(8, subDistrict);
        stm.setString(9, district);
        stm.setString(10, province);
        stm.setInt(11, postCode);
        stm.setString(12, resTel);
        stm.setString(13, resTime);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            allRestaurant.add(r);
        }
        
        return allRestaurant;
    }
    public static ArrayList addRestaurant
        (int resId,String userName,String resName,String resType
                ,String resAdd,String resNo,String road,String subDistrict,String district,String province
                ,int postCode,String resTel,String resTime) 
                throws ClassNotFoundException, SQLException{
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder2.getConnection();
        String sqlCmd = "INSERT INTO Restaurant VALUES (?,'?','?','?','?','?','?','?','?','?',?,'?','?')";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1, resId);
        stm.setString(2, userName); 
        stm.setString(3, resName);
        stm.setString(4, resType);
        stm.setString(5, resAdd);
        stm.setString(6, resNo);
        stm.setString(7, road);
        stm.setString(8, subDistrict);
        stm.setString(9, district);
        stm.setString(10, province);
        stm.setInt(11, postCode);
        stm.setString(12, resTel);
        stm.setString(13, resTime);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            allRestaurant.add(r);
        }
        
        return allRestaurant;
    }
    public static ArrayList showAllRestaurant() throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder2.getConnection();
        String sqlCmd = "SELECT * FROM Restaurant";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            orm(r, rs);
            allRestaurant.add(r);
        }
        return allRestaurant;
    }

    public static ArrayList findStoreName(String resName) throws SQLException, ClassNotFoundException {
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder2.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "SELECT * FROM Restaurant r WHERE r.resname like ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setString(1, resName+"%");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            restaurant.add(r);
        }
        return restaurant;
    }
     public static ArrayList findStore(int resId) throws SQLException, ClassNotFoundException {
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder2.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "SELECT * FROM Restaurant r WHERE r.res_id = ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1, resId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            restaurant.add(r);
        }
        return restaurant;
    }
    public String getAllString() {
        return getResId() + " " + getResName()+ " " + getNameAdd() + " " + getResType() + ", " + getNameAdd() + ", " + getSubDistrict() + ", " + getDistrict() + ", " + getProvince() + ", " + getResTel() + ", " + getResTime();
    }

    private static Restaurant orm(Restaurant r, ResultSet rs) throws SQLException {
        //--------------Restaurant-----------------
        r.setResId(rs.getInt("res_id"));
        r.setResName(rs.getString("resName"));
        r.setResType(rs.getString("resType"));
        r.setResTel(rs.getString("resTel"));
        r.setResTime(rs.getString("resTime"));
        //--------------Location-------------------
        r.setNameAdd(rs.getString("resAdd"));
        r.setNoRes(rs.getString("resNo"));
        r.setRoad(rs.getString("road"));
        r.setSubDistrict(rs.getString("subDistrict"));
        r.setDistrict(rs.getString("district"));
        r.setProvince(rs.getString("province"));
        r.setPostCode(rs.getInt("postCode"));
        return r;
    }

    public Review[] getReview() {
        return review;
    }

    public void setReview(Review[] review) {
        this.review = review;
    }

    public int getNumReview() {
        return review.length;
    }
//    public int getReviewScore() {
//        return getReview().getAvgScore();
//    }

//    public int getAvgScore() {
//        int temp = (int) (getReviewScore().getAvg() * 10);
//        return temp;
//    }
    public String getNameStore() {
        String temp = getResName().substring(0, 1);
        return temp;
    }

    public int compareTo(Object obj) {
        int result = 0;
        if (obj != null && obj instanceof Restaurant) {
            Restaurant r = (Restaurant) obj;
            if (orderBy.equalsIgnoreCase("numReview")) {
                result = r.getNumReview() - this.getNumReview();
            } else if (orderBy.equalsIgnoreCase("score")) {
//                result = r.getAvgScore() - this.getAvgScore();
            } else {
//                result = this.getNameStore().compareTo(r.getNameStore());
                result = this.getResName().compareTo(r.getResName());
            }
        }
        return result;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getResTel() {
        return resTel;
    }

    public void setResTel(String resTel) {
        this.resTel = resTel;
    }

    public String getResTime() {
        return resTime;
    }

    public void setResTime(String resTime) {
        this.resTime = resTime;
    }

//Getter Setter ที่เพิ่ม
    public String getNameAdd() {
        return nameAdd;
    }

    public void setNameAdd(String nameAdd) {
        this.nameAdd = nameAdd;
    }

    public String getNoRes() {
        return noRes;
    }

    public void setNoRes(String noRes) {
        this.noRes = noRes;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ArrayList<Restaurant> allRestaurant = Restaurant.showAllRestaurant();
//        for (int i = 0; i < allRestaurant.size(); i++) {
//            Restaurant r = allRestaurant.get(i);
//            System.out.println(r.getResId() + " " + r.getResName() + " " + r.getResType()+ " ");
//            System.out.println("---------------------------");
//        }
//    }
    public static int getCount() {
        return count;
    }

    public String toString() {
        return " ชื่อร้าน: " + resName
                + " ประเภท: " + resType
                + "\n\tที่อยู่: " + location
                + " เวลาเปิด-ปิด: " + resTime;
    }
}
