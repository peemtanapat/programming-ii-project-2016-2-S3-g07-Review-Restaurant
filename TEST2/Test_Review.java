package TEST2;

import java.util.Scanner;

public class Test_Review {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        Review rv;

        System.out.println("-----------รีวิว-----------");
        System.out.print("Writer Name: ");
        String writerName = sc.nextLine();
        System.out.print("User ID: ");
        int userID = sc.nextInt();
        
        System.out.print("Food: ");
        String foodName = sc.nextLine();
        sc.next();
        System.out.print("Price: ");
        double foodPrice = sc.nextDouble();
        System.out.print("Store: ");
        String storeName = sc.nextLine();
        sc.next();
        System.out.print("Location: ");
        String storeLocation = sc.nextLine();
        sc.next();
        System.out.print("Review Here: ");
        String reviewContent = sc.nextLine();
        sc.next();
        Review rv = new Review(foodName, foodPrice, storeName, storeLocation, reviewContent, writerName, userID);
        System.out.println("----------Score----------");
        System.out.println("Range(1-5)");
        System.out.print("1.Taste: ");
        int taste = sc.nextInt();
        System.out.print("2.Value: ");
        int value = sc.nextInt();
        System.out.print("3.Cleanness: ");
        int clean = sc.nextInt();
        System.out.print("4.Look: ");
        int look = sc.nextInt();
       
         rv = new Score(taste, value, clean, look);
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("#########แสดงผล#########");
        System.out.println(rv.toString());
    }
}
