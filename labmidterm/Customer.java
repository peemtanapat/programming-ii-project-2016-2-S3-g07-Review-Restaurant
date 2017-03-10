package labmidterm;
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
