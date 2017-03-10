/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package No4;

/**
 *
 * @author INT105
 */
public abstract class Item implements Comparable<Item> {
    protected String appName;
    protected String category;
    private double price;
    private String orderBy;

    public Item() {
    }
 
    public Item(String appName, String category, double price) {
        this.appName = appName;
        this.category = category;
        this.price = price;
    }

    public static String getOrderBy() {
        return "";
    }

    public static void setOrderBy(String orderBy) {
        orderBy = orderBy;
    }
    
    public int compareTo(Item o){
        if(orderBy.equalsIgnoreCase(""))
    }
    public abstract String getType();

    @Override
    public String toString() {
        return "Item{" + "appName=" + appName + ", category=" + category + ", price=" + price + ", orderBy=" + orderBy + '}';
    }
     
    
    
}
