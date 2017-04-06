package Test_DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import project_review.Restaurant;


public class Test_AddStore_Conncection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        (int resId,String userName,String resName,String resType
//                ,String resAdd,String resNo,String road,String subDistrict,String district,String province
//                ,int postCode,String resTel,String resTime) 
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Create Restaurant-------");
//        System.out.print("Username(Writer): ");
//        String user = sc.nextLine();
//        System.out.print("Restaurant ID: ");
//        int id = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Restaurant name: ");
//        String name = sc.nextLine();
//        System.out.print("Type(eg.Buffet,Restaurant,Bakery,Tea-Coffee,Dessert): ");
//        String type = sc.nextLine();
//        System.out.println("---Address information---");
//        System.out.print("Main location: ");
//        String resAdd = sc.nextLine();
//        System.out.print("Number: ");
//        String no = sc.nextLine();
//        System.out.print("Road: ");
//        String road = sc.nextLine();
//        System.out.print("Subdistrict: ");
//        String sub = sc.nextLine();
//        System.out.print("District: ");
//        String district = sc.nextLine();
//        System.out.print("Province: ");
//        String province = sc.nextLine();
//        System.out.print("Post code: ");
//        int postCode = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Tel: ");
//        String resTel = sc.nextLine();
//        System.out.print("Time(eq. 18.00-23.00): ");
//        String resTime = sc.nextLine();
            int id = 99;
            String user = "tanapat128";
//            String name = "ป้าปุ้ยก๋วยเตี๋ยว";
            String name = "GGG";
            String type = "ตามสั่ง";
            String resAdd = "ใกล้ KMUTT";
            String no = "110/2";
            String road = "ประชาอุทิศ";
            String sub = "บางมด";
            String district = "ทุ่งครุ";
            String province = "กรุงเทพฯ";
            int postCode = 10140;
            String resTel = "081-651-5333";
            String resTime = "08.00-15.00";
            
        ArrayList<Restaurant> allRestaurant = Restaurant.addRestaurant(id,user,name,type,resAdd,no,road,sub,district,province,postCode,resTel,resTime);
        for (int i = 0; i < allRestaurant.size(); i++) {
            Restaurant r = allRestaurant.get(i);
            System.out.println(r.getAllString());
            System.out.println("---------------------------");
        }
    }
}
