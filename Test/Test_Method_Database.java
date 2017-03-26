package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import project_review.Review;
import project_review.Restaurant;
import project_review.User;
import project_review.Score;

public class Test_Method_Database {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         ArrayList<Restaurant> allRestaurant = Restaurant.showAllRestaurant();
         for (int i = 0; i < allRestaurant.size(); i++) {
             Restaurant r = allRestaurant.get(i);
             System.out.println(r.getResId()+" "+r.getResName()+" "+r.getResType()+" "+r.getLocation().getNameAdd()+" "+r.getLocation());
             System.out.println("---------------------------");
         }
    }
    
}
