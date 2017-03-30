package Test;

import java.util.Scanner;
import project_review.Location;
import project_review.Restaurant;
import project_review.User;

public class Test_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("Tanapat128");
        Restaurant[] store = new Restaurant[2];
        Location[] location = new Location[2];
        location[0] = new Location("Central RamaII", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140); 
        location[1] = new Location("Lotus Bangpakok", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140); 
//        store[0] = new Restaurant(101, "Bar-B-Q", "Buffet", location[0], "099-192-2590", "8.00-22.00");
//        store[1] = new Restaurant(102, "MK", "Restaurant", location[1], "099-192-2590", "13.00-18.00");
        System.out.println("All Store");
        for (int i = 0; i < store.length; i++) {
            System.out.println("Number " + i + ". " + store[i] + "\n");
        }
    }
}
