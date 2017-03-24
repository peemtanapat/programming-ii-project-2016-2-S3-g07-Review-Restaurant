package projectjava;

public class Store{
    
    private String storeName;
    private String storeType;
    private String location;
    private String time;
    private static int count;  

    public Store() {
    }

    public Store(String storeName, String storeType, String location, String time) {
        this.storeName = storeName;
        this.storeType = storeType;
        this.location = location;
        this.time = time;
        count++;
    }

    

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    public static int getCount() {
        return count;
    }

    public String toString() {
        return  " ชื่อร้าน: " + storeName
                + " ประเภท: " + storeType
                + "\n\tที่อยู่: " + location
                + " เวลาเปิด-ปิด: " + time;
    }
}
