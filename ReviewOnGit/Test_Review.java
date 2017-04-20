package project_review;

import java.util.Scanner;

public class Test_Review {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("Tanapat128");
        Restaurant[] store = new Restaurant[2];
        Location[] l = new Location[2];  //Location(String nameAdd, String noRes, String road, String subDistrict, String district, String province, int postCode)
        //Restaurant(int resId, String resName, String resType, Location location, String resTel, String resTime)
        l[0] = new Location("Central RamaII", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140); //nameAdd,  noRes,  road,  subDistrict,  district,  province,  postCode,  resTel)
        l[1] = new Location("Lotus Bangpakok", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140); //nameAdd,  noRes,  road,  subDistrict,  district,  province,  postCode,  resTel)
//        store[0] = new Restaurant(101, "Bar-B-Q", "Buffet", l[0], "099-192-2590", "8.00-22.00");
//        store[1] = new Restaurant(102, "MK", "Restaurant", l[1], "099-192-2590", "13.00-18.00");

        System.out.println("All Store");
        for (int i = 0; i < store.length; i++) {
            System.out.println("Number " + i + ". " + store[i] + "\n");
        }
        System.out.print("Choose the store to review" + "(0-" + (store.length - 1) + "): ");
        int storeNum = sc.nextInt();
        System.out.println("-----Score------");
        System.out.print("1.Taste(0-5): ");
        int taste = sc.nextInt();
        System.out.print("2.Cleanness(0-5): ");
        int clean = sc.nextInt();
        System.out.print("3.Service(0-5): ");
        int service = sc.nextInt();
        System.out.print("4.Look(0-5): ");
        int look = sc.nextInt();
        System.out.print("5.Value(0-5): ");
        int worth = sc.nextInt();
        sc.nextLine();
        Score score = new Score(taste, clean, service, look, worth);
        System.out.print("Review write here: ");
        String content = sc.nextLine();
        
        //ArrayList findStore
//        System.out.print("You want to delete comment YES/NO : ");
//        String delete = sc.nextLine();
        //Review r1 = new Review(user, store[0], score, content);

        //System.out.println(r1);
//        r1.setDelete(delete);
//        System.out.println(r1);
    }
}
