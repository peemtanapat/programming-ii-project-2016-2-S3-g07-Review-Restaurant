package project_review;

public class Location {

    private String nameAdd; //ชื่อที่อยู่หลัก เช่น central plaza Rama II
    private String noRes; //เลขที่บ้าน
    private String road; //ถนน
    private String subDistrict; //ตำบล/แขวง
    private String district; //อำเภอ/เขต
    private String province; //จังหวัด
    private int postCode; //เลขไปรษณีย์
   

    public Location() {
    }

    public Location(String nameAdd, String noRes, String road, String subDistrict, String district, String province, int postCode) {
        this.nameAdd = nameAdd;
        this.noRes = noRes;
        this.road = road;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Location{" + "nameAdd=" + nameAdd + ", noRes=" + noRes + ", road=" + road + ", subDistrict=" + subDistrict + ", district=" + district + ", province=" + province + ", postCode=" + postCode + '}';
    }

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


}
