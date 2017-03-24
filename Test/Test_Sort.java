package Test;

import java.util.Arrays;
import projectjava.Review;
import projectjava.Store;
import projectjava.User;
import projectjava.Score;

public class Test_Sort {

    public static void main(String[] args) {
        User u1 = new User("Tanapat128");
        Store[] store = new Store[3];
        store[0] = new Store("Bar-B-Q", "Buffet", "Rama2", "8.00-22.00");
        store[1] = new Store("MK", "Restaurant", "Bangmod", "13.00-18.00");
        store[2] = new Store("KIN-KIN", "Sha-bu", "Bangmod", "18.00-22.00");
        Score score1 = new Score(5, 4, 3, 5, 2);
        Score score2 = new Score(3, 4, 1, 4, 3);
        Score score3 = new Score(5, 5, 5, 5, 5);
        Review r[] = new Review[3];
        r[0] = new Review(u1, store[0], score1, "Good");
        r[1] = new Review(u1, store[1], score2, "Good");
        r[2] = new Review(u1, store[2], score3, "Good");
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
