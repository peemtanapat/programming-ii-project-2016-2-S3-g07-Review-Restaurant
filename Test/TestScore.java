package Test;
import java.util.Scanner;

public class TestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
    }
}
