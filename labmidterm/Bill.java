package labmidterm;

public abstract class Bill {

    protected long billId = 1;
    private Customer cust;
    private double totalPrice;
    private double promoPrice;

    public Bill(Customer cust, double totalPrice) {
        this.cust = cust;
        this.totalPrice = totalPrice;
       
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Bill bill, double minPrice, double percentPro, double maxPro) {
        if(totalPrice>=minPrice){
            this.promoPrice = (this.totalPrice*percentPro)/100;
            if(promoPrice>200){
                this.promoPrice =200;
            }else{
                this.promoPrice = (this.totalPrice*percentPro)/100;
            }
        }else{
            this.promoPrice=0;
        }   
        
    }

    @Override
    public String toString() {
        return "Bill id: " + billId;
    }

}
