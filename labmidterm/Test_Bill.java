package labmidterm;

public class Test_Bill {

    public static void main(String[] args) {
        Customer[] cust = new Customer[2];
        cust[0] = new Customer();
        cust[1] = new Customer();
        
        Bill[] bills = new Bill[4];
        bills[0] = new FoodBill(cust[0], 500);
        bills[1] = new FoodBill(cust[1], 500);
        bills[2] = new GoodsBill(cust[0], 5000);
        bills[3] = new GoodsBill(cust[1], 3500);
        
    }
}
