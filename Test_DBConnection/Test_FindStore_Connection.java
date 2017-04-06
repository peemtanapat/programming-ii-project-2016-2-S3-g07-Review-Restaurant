package Test_DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import project_review.Restaurant;
import java.util.Scanner;
public class Test_FindStore_Connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Search Restaurants-------");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        ArrayList<Restaurant> allRestaurant = Restaurant.findStoreByName(name);
        for (int i = 0; i < allRestaurant.size(); i++) {
            Restaurant r = allRestaurant.get(i);
            System.out.println(r.getResId() + " " + r.getResName() + " " + r.getResType()+ " ");
            System.out.println("---------------------------");
        }
        
        
    }
}
