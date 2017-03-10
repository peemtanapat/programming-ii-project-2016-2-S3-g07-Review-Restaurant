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
public class FoodBill extends GoodsBill {

    public FoodBill(Customer cust,double price) {
        this.cust = cust;
        this.price = price;
        count++;
    }
    
    public long getNumOfBill() {
        return count;
    }
    
    public String toString() {
        return "Food Bill, Bill id: "+count+" Customer id: "+custId+"\nTotal Price = "+getTotalPrice+", Promotion Price="+promoPrice+"\nNet : "+(getTotalprice-promoPrice);
    }
}

