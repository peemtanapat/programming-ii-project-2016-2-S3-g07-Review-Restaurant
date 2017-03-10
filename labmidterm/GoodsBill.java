
package labmidterm;

public class GoodsBill extends Bill {
    private long count;

    public GoodsBill(Customer cust,double price) {
        this.cust = cust;
        this.price = price;
        count++;
    }
    
    public long getNumOfBill() {
        return count;
    }
    
    public String toString() {
        return "Goods Bill, Bill id: "+count+" Customer id: "+custId+"\nTotal Price = "+getTotalPrice+", Promotion Price="+promoPrice+"\nNet : "+(getTotalprice-promoPrice);
    }
}
