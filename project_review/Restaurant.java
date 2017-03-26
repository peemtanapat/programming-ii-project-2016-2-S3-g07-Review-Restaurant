package project_review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Restaurant extends Location{

    private int resId; 
    private String resName;
    private String resType; //ประเภทของร้าน ex. buffet restaurant pub bar
    private Location location; 
    private String resTel; //เบอร์โทร
    private String resTime; //เวลาปิด-เปิดร้าน ex. 18.00 - 22.00
    private User user;
    private Review review;
    private static int count;

    public Restaurant() {
    }

    public Restaurant(int resId, String resName, String resType, Location location, String resTel, String resTime) {
        this.resId = resId;
        this.resName = resName;
        this.resType = resType;
        this.location = location;
        this.resTel = resTel;
        this.resTime = resTime;
        count++;
    }
public static void main(String[] args) throws ClassNotFoundException, SQLException {
         ArrayList<Restaurant> allRestaurant = Restaurant.showAllRestaurant();
         for (int i = 0; i < allRestaurant.size(); i++) {
             Restaurant r = allRestaurant.get(i);
             System.out.println(r.getResId()+" "+r.getResName()+" "+r.getResType()+" "+r.getLocation().getNameAdd()+" "+r.getLocation());
             System.out.println("---------------------------");
         }
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
  public static ArrayList findStore(int resId) throws SQLException, ClassNotFoundException{
        ArrayList<Restaurant> restaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        String sqlCmd = "SELECT r.resId, r.resName FROM Restaurant r JOIN Review re ON r.reviewId = re.reviewId WHERE r.resId = ?";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        stm.setInt(1,resId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Restaurant r = new Restaurant();
            Restaurant.orm(r, rs);
            restaurant.add(r);
        }
        return restaurant;
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
