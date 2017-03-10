package labmidterm;

public class GoodsBill extends Bill {

    private static long count = 0;

    public GoodsBill(Customer cust, double price) {
        super(cust, price);
        count++;
        this.billId = count;
    }

    public long getNumOfBill() {
        return count;
    }

    public String toString() {
        return "Goods Bill, Bill id: " + billId + " " + getCust() + "\nTotal Price = " + getTotalPrice() + ", Promotion Price=" + getPromoPrice() + "\nNet : " + (getTotalPrice() - getPromoPrice());
    }
}
