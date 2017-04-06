package Test_DBConnection;




import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import project_review.Review;

public class Test_Review_Conncection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
            int reId = 1;
            String user = "tanapat128";
            int resId = 1;

            String top = "Not Bad";
            String con = "ตามสั่ง";
            int taste = 5;
            int clean = 4;
            int service = 3;
            int look = 3;
            int worth = 4;
            
            DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
            Date d1 = df.parse("2017-04-06");
            //Date date = "2017-04-06";
//            Date currentDate = new Date();
//            String time=request.getParameter("date");
//            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
//            java.util.Date date1 = (java.util.Date)formatter.parse(time);
//            ArrayList<Review> rev = Review.reviewRes(reId,user,resId,top,con,taste,clean,service,look,worth,d1);
//        for (int i = 0; i < rev.size(); i++) {
//            Review r = rev.get(i);
//            System.out.println(r.getAllString());
//            System.out.println("---------------------------");
//        }






//        stm.setInt(1, reId);
//        stm.setString(2, user);
//        stm.setInt(3, resId);
//        stm.setString(4, top);
//        stm.setString(5, content);
//        stm.setInt(6, taste);
//        stm.setInt(7, clean);
//        stm.setInt(8, service);
//        stm.setInt(9, look);
//        stm.setInt(10, worth);
   
    }
}
