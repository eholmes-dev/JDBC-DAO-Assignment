/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ech.dao.java.order;

import java.time.LocalDate;
/**
 *
 * @author ethan
 */
public class Order {
    /**
     * The default OrderNumber to use.
     */
    private static final int DEFAULT_ID = 0;
    
    
    /**
     * default unique id
     */
    private int id;
    
    /**
     * The number of the order.
     */
    private int orderNumber;
    
    /**
     * The date of the order
     */
    private LocalDate orderDate;
    
    /**
     * the id of the vendor.
     */
    private int vendorId;

    /**
     * full constructor.
     * 
     * @param id
     * @param orderNumber
     * @param orderDate
     * @param vendorId 
     */
    public Order(int id, int orderNumber, LocalDate orderDate
            , int vendorId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.vendorId = vendorId;
    }

    /**
     * Partial constructor takes everything but ID.
     * 
     * @param orderNumber
     * @param orderDate
     * @param vendorId 
     */
    public Order(int orderNumber, LocalDate orderDate
            , int vendorId) {
        this(DEFAULT_ID, orderNumber,orderDate, vendorId);
    }

    /**
     * 0 argument constructor.
     */
    public Order() {
        this.id = DEFAULT_ID;
    }

    /**
     * This is the copy constructor.
     * @param other Order to be copied.
     */
    public Order(Order other){
        this.id = other.getId();
        this.orderNumber = other.getOrderNumber();
        this.orderDate = other.getOrderDate();
        this.vendorId = other.getVendorId();
    }
    
    
    /**
     * An override of the toString() method.  
     * @return string representation of the order
     */
    @Override
    public String toString() {
        return "ID  " + id + ":: " +
                "Order Number  " + orderNumber + ":: " +
                "Order Date  " + orderDate + ":: " +
                "Vendor Id  " + vendorId;
    }
    

    /**
     * A unique identifier.
     * A zero value means this is a new record not stored
     * in the database.
     * Cannot be negative.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * A unique identifier.
     * A zero value means this is a new record not stored
     * in the database.
     * Cannot be negative.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The orderNumber for an Order record.
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    /**
     * orderDate for an Order record
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * get orderDate
     * @return the orderDate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * vendorId 
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

  
    /**
     * Needed for the Comparable interface.
     * 
     * @param other the other order
     * @return 
     */
    public int compareTo(Order other) {
        return (this.orderNumber + "|"+this.vendorId)
                .compareTo(other.getOrderNumber() 
                        + "|" + other.getVendorId());
    }
    
    /**
     * sets the order date.
     * @param OrderDateTime 
     */
    void setOrderDate(String OrderDateTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
