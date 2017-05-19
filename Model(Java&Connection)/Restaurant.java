package model;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Restaurant extends User {

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


    public Restaurant() {
    }

    public Restaurant(int resId, String resName, String resType, String resTel, String resTime) {
        this.resId = resId;
        this.resName = resName;
        this.resType = resType;
        this.resTel = resTel;
        this.resTime = resTime;
        count++;
    }

    public Restaurant(int resId, String userName, String resName, String resType, String resTel, String resTime, String nameAdd, String road, String province) {
        this.resId = resId;
        this.userName = userName;
        this.resName = resName;
        this.resType = resType;
        this.resTel = resTel;
        this.resTime = resTime;
        this.nameAdd = nameAdd;
        this.road = road;
        this.province = province;
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
        return restaurant;
    }

    public static ArrayList showRestaurant(String sqlCmd) throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
//        String sqlCmd = "SELECT * FROM Restaurant";
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

    public int insertRestaurantInDB() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Restaurant VALUES (?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        int result = -1;
        int numRows = getNumRow();
        numRows = numRows + 1;
        try {
            conn = ConnectionBuilder.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, numRows);
            pst.setString(2, userName);
            pst.setString(3, resName);
            pst.setString(4, resType);
            pst.setString(5, nameAdd);
            pst.setString(6, road);
            pst.setString(7, province);
            pst.setString(8, resTel);
            pst.setString(9, resTime);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
        }
    }

    public int updateRestaurantInDB() {
        String sql = "UPDATE restaurant SET resname=?,restype=?,resadd=?,road=?,province=?,restel=?,restime=? WHERE res_id=?";
        Connection conn = null;
        int result = -1;
        try {
            conn = ConnectionBuilder.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, resName);
            pst.setString(2, resType);
            pst.setString(3, nameAdd);
            pst.setString(4, road);
            pst.setString(5, province);
            pst.setString(6, resTel);
            pst.setString(7, resTime);
            pst.setInt(8, resId);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
        }
    }

    public int deleteRestaurantInDB() {
        String sql = "DELETE FROM restaurant WHERE res_id = ?";
        Connection conn = null;
        int result = -1;
        try {
            conn = ConnectionBuilder.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, resId);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
        }
    }

    public static ArrayList addRestaurant(String userName, String resName, String resType,
            String resAdd, String road, String province,
            String resTel, String resTime)
            throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = new ArrayList();
        Connection con = ConnectionBuilder.getConnection();
        String sqlCmd = "INSERT INTO Restaurant VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sqlCmd);
        int numRows = getNumRow();
        numRows = numRows + 1;

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
        r.setRoad(rs.getString("road"));
        r.setProvince(rs.getString("province"));
        return r;
    }

    public String getNameStore() {
        String temp = getResName().substring(0, 1);
        return temp;
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

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "table=" + table + ", userName=" + userName + ", resId=" + resId + ", resName=" + resName + ", resType=" + resType + ", resTel=" + resTel + ", resTime=" + resTime + ", nameAdd=" + nameAdd + ", road=" + road + ", province=" + province + '}';
    }

 
}
