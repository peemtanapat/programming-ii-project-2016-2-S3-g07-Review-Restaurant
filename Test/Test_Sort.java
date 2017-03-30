package Test;

import java.util.Arrays;
import project_review.Location;
import project_review.Review;
import project_review.Restaurant;
import project_review.User;
import project_review.Score;

public class Test_Sort {

    public static void main(String[] args) {
        User u1 = new User("Tanapat128");

        Location[] location = new Location[3];
        location[0] = new Location("Central RamaII", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140);
        location[1] = new Location("Lotus Bangpakok", "126", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140);
        location[2] = new Location("Opposite KMUTT", "227/11", "Pracha Uthit Rd", "Bang Mot", "Thung Khru", "Bangkok", 10140);
        Restaurant[] store = new Restaurant[3];
//        store[0] = new Restaurant(101, "Bar-B-Q", "Buffet", location[0], "099-192-2590", "8.00-22.00");
//        store[1] = new Restaurant(102, "MK", "Restaurant", location[1], "099-192-2590", "13.00-18.00");
//        store[2] = new Restaurant(103, "KIN-KIN", "Sha-bu", location[2], "099-192-2590", "18.00-22.00");
        Score score1 = new Score(5, 4, 3, 5, 2);
        Score score2 = new Score(3, 4, 1, 4, 3);
        Score score3 = new Score(5, 5, 5, 5, 5);
        Review r[] = new Review[3];
//        r[0] = new Review(u1, store[0], score1, "Good");
//        r[1] = new Review(u1, store[1], score2, "Medium");
//        r[2] = new Review(u1, store[2], score3, "Good");
        showMe(r);
        Review.setOrderBy("score");
        showMe(r);

    }

    public static void showMe(Review[] items) {
        Arrays.sort(items);
        System.out.println("Order By: " + Review.getOrderBy());
        for (Review item : items) {
            System.out.println(item);
        }
        System.out.println("");
    }
}
