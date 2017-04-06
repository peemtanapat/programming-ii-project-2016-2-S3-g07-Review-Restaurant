package Test_DBConnection;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import project_review.Review;

public class Test_Review_Conncection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Review---");
        System.out.print("Input Review ID: ");
        int reId = sc.nextInt();
        System.out.print("Input Restaurant ID: ");
        int resId = sc.nextInt();
        System.out.print("Username: ");
        String user = sc.next();
        sc.nextLine();
        System.out.print("Review Topic: ");
        String top = sc.nextLine();
        System.out.print("Comment: ");
        String con = sc.nextLine();
 
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

//            int reId = 1;
//            String user = "tanapat128";
//            int resId = 1;
//            String top = "Not Bad";
//            String con = "ตามสั่ง";
//            int taste = 5;
//            int clean = 4;
//            int service = 3;
//            int look = 3;
//            int worth = 4;
        ArrayList<Review> rev = Review.reviewRes(reId, user, resId, top, con, taste, clean, service, look, worth);

        for (int i = 0; i < rev.size(); i++) {
            Review r = rev.get(i);
            System.out.println(r.getAllString());
            System.out.println("---------------------------");
        }

    }
}
