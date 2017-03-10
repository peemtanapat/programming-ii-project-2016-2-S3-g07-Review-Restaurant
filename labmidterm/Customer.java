/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmidterm;

/**
 *
 * @author INT105
 */
public class Customer {
    private long custId;
    private static long count=1;
    
    public Customer(){
        this.custId = count++;
    }
    public long getNumOfCustomer(){
        return count++;
    }
    public long getCustId(){
        return custId;
    }
    public String toString(){
        return "Customer Id : "+custId;
    }
}
