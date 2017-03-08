package Project_Review;

import java.util.Scanner;

public class Test_Review {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("Tanapat128");
        Store[] store = new Store[2];
        store[0] = new Store("Bar-B-Q", "Buffet", "Rama2", "8.00-22.00");
        store[1] = new Store("MK", "Restaurant", "Bangmod", "13.00-18.00");

        System.out.println("All Store");
        for (int i = 0; i < store.length; i++) {
            System.out.println("Number " + i + ". " + store[i] + "\n");
        }
        System.out.print("Choose the store to review" + "(0-" + (store.length - 1) + "): ");
        int storeNum = sc.nextInt();
        System.out.println("-----Score------");
        System.out.print("1.Taste: ");
        int taste = sc.nextInt();
        System.out.print("2.Cleanness: ");
        int clean = sc.nextInt();
        System.out.print("3.Service: ");
        int service = sc.nextInt();
        System.out.print("4.Look: ");
        int look = sc.nextInt();
        System.out.print("5.Value: ");
        int value = sc.nextInt();
        sc.nextLine();
        Score score = new Score(taste, clean, service, look, value);
        System.out.print("Review write here: ");
        String content = sc.nextLine();
        Review r1 = new Review(user, store[storeNum], score, content);\\55555
        System.out.println(r1);
    }
}
