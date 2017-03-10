/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmidterm;

/**
 *
 * @author USER
 */
public class FoodBill extends Bill {
    private static long count=0;
     
    public FoodBill(Customer cust,double price) {
        super(cust,price);
        count++;
        this.billId = count;
    }
    
    
    public long getNumOfBill() {
        return count;
    }
    
    public String toString() {
        return "Food Bill,Bill id: " + billId + " "+getCust() + "\nTotal Price = " + getTotalPrice() + ", Promotion Price=" + getPromoPrice() + "\nNet : " + (getTotalPrice() - getPromoPrice());
    }
}

