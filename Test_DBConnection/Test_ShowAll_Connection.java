package Test_DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import project_review.Restaurant;

public class Test_ShowAll_Connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<Restaurant> allRestaurant = Restaurant.showAllRestaurant();
      
        for (int i = 0; i < allRestaurant.size(); i++) {
            Restaurant r = allRestaurant.get(i);
            System.out.println(r.getAllString());
            System.out.println("---------------------------");
        }
    }
}
