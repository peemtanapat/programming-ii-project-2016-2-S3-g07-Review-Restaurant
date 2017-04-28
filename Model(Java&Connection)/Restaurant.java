package project_review;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Restaurant extends User implements Comparable {

    JTable table;
//Userผู้เขียนร้าน    
    private String userName;
//INFORMATION    
    private int resId = 0;    //ไอดีร้าน
    private static int count = 0; //RunningId
    private String resName; //ชื่อร้าน
    private String resType; //ประเภทของร้าน ex. buffet restaurant pub bar
    private String resTel;  //เบอร์โทร
    private String resTime; //เวลาปิด-เปิดร้าน ex. 18.00 - 22.00
//LOCATION
    private String nameAdd; //ชื่อที่อยู่หลัก เช่น central plaza Rama II
//    private String noRes;   //เลขที่บ้าน
    private String road;    //ถนน
//    private String subDistrict; //ตำบล/แขวง
//    private String district; //อำเภอ/เขต
    private String province; //จังหวัด
//    private int postCode;    //เลขไปรษณีย์
//Other
    private static String orderBy = "name";
    private Location location;

    public Restaurant() {
    }

    public Restaurant(int resId, String resName, String resType, String resTel, String resTime, Location location) {
        this.resId = resId;
        this.resName = resName;
        this.resType = resType;
        this.resTel = resTel;
        this.resTime = resTime;
        this.location = location;
        count++;
    }

    public static ResultSet showAllRestaurantResult() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        String sqlCmd = "SELECT * FROM Restaurant";
        Statement stm = con.createStatement();
        rs = stm.executeQuery(sqlCmd);
        while (rs.next()) {
            Restaurant r = new Restaurant();
            orm(r, rs);
            allRestaurant.add(r);
        }
        return rs;
    }

    public static ResultSet findStoreResult(String resName) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "SELECT * FROM Restaurant r WHERE r.resname like ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setString(1, resName + "%");
        rs = stm.executeQuery();
//        while (rs.next()) {
//            Restaurant r = new Restaurant();
//            Restaurant.orm(r, rs);
//            restaurant.add(r);
//        }
        return rs;
    }

    public static ArrayList sortRestaurant(String orderBy) throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        Statement statement = con.createStatement();

        String sqlCmd = "SELECT * FROM APP.RESTAURANT ORDER BY ?";
//        String sql = "SELECT * FROM Restaurant ORDER BY ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setString(1, orderBy);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            orm(r, rs); //orm(objClass,Resultset)
            allRestaurant.add(r);
        }
        return allRestaurant;
    }

    public static ArrayList findStoreByName(String resName) throws SQLException, ClassNotFoundException {
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        String sqlCmd = "SELECT * FROM Restaurant r WHERE r.resname like ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setString(1, resName + "%");
        ResultSet rs = stm.executeQuery();
//        while (rs.next()) {
//            Restaurant r = new Restaurant();
//            Restaurant.orm(r, rs);
//            restaurant.add(r);
//        }
        return restaurant;
    }

    public static ArrayList showAllRestaurant() throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        String sqlCmd = "SELECT * FROM Restaurant";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlCmd);
        while (rs.next()) {
            Restaurant r = new Restaurant();
            orm(r, rs);
            allRestaurant.add(r);
        }
        return allRestaurant;
    }

    public static Integer getNumRow() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT COUNT(*) AS NUMROWS FROM RESTAURANT");
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int numrows = rs.getInt("NUMROWS");
        return numrows;
    }

    public static ArrayList addRestaurant(String userName, String resName, String resType,
            String resAdd, String road, String province,
            String resTel, String resTime)
            throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        Statement statement = con.createStatement();
        String sqlCmd = "INSERT INTO Restaurant VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        int numRows = getNumRow();
        numRows = numRows + 1;
//        Statement getMaxId = con.createStatement();
//        getMaxId.executeUpdate("SELECT MAX(resId) FROM Restaurant");
        stm.setInt(1, numRows);
        stm.setString(2, userName);
        stm.setString(3, resName);
        stm.setString(4, resType);
        stm.setString(5, resAdd);
        stm.setString(6, road);
        stm.setString(7, province);
        stm.setString(8, resTel);
        stm.setString(9, resTime);

        stm.executeUpdate();

        return allRestaurant;
    }

    public void findStoreGUI(String resName) throws SQLException, ClassNotFoundException {

        table.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("res_id");
        model.addColumn("username");
        model.addColumn("resName");
        model.addColumn("resAdd");
        model.addColumn("resType");
        model.addColumn("road");
        model.addColumn("province");
        model.addColumn("resTel");
        model.addColumn("resTime");

        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";

        String sqlCmd = "SELECT * FROM Restaurant  WHERE resname like ?";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlCmd);
        int row = 0;
//        stm.setString(1, resName+"%");

        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            restaurant.add(r);
        }

    }

    public static ArrayList findStoreById(int resId) throws SQLException, ClassNotFoundException {
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
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

    public String printAll() {
        String output = getResId() + " " + getResName() + " - " + getNameAdd() + ", " + getResType() + ", " + getNameAdd() + ", " + getProvince() + ", " + getResTel() + ", " + getResTime()
                + "\n---------------------------";
        return output;
    }

    private static Restaurant orm(Restaurant r, ResultSet rs) throws SQLException {
        //--------------Restaurant-----------------
        r.setResId(rs.getInt("res_id"));
        r.setUserName(rs.getString("userName"));
        r.setResName(rs.getString("resName"));
        r.setResType(rs.getString("resType"));
        r.setResTel(rs.getString("resTel"));
        r.setResTime(rs.getString("resTime"));
        //--------------Location-------------------
        r.setNameAdd(rs.getString("resAdd"));
//        r.setNoRes(rs.getString("resNo"));
        r.setRoad(rs.getString("road"));
//        r.setSubDistrict(rs.getString("subDistrict"));
//        r.setDistrict(rs.getString("district"));
        r.setProvince(rs.getString("province"));
//        r.setPostCode(rs.getInt("postCode"));
        return r;
    }
//
//    public Review[] getReview() {
//        return review;
//    }
//
//    public void setReview(Review[] review) {
//        this.review = review;
//    }
//
//    public int getNumReview() {
//        return review.length;
//    }
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
//                result = r.getNumReview() - this.getNumReview();
            } else if (orderBy.equalsIgnoreCase("score")) {
//                result = r.getAvgScore() - this.getAvgScore();
            } else {
//                result = this.getNameStore().compareTo(r.getNameStore());
                result = this.getResName().compareTo(r.getResName());
            }
        }
        return result;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

//    public String getNoRes() {
//        return noRes;
//    }
//
//    public void setNoRes(String noRes) {
//        this.noRes = noRes;
//    }
    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

//    public String getSubDistrict() {
//        return subDistrict;
//    }
//
//    public void setSubDistrict(String subDistrict) {
//        this.subDistrict = subDistrict;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

//    public int getPostCode() {
//        return postCode;
//    }
//
//    public void setPostCode(int postCode) {
//        this.postCode = postCode;
//    }
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
