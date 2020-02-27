
package ech.dao.java.order.data;

import ech.dao.java.order.Order;
import java.util.List;
/**
 *
 * @author ethan
 */
public interface OrderDAO {
    
    /**
     * 
     * @param order
     * @throws OrderDataException 
     */
    void createOrder(Order order) throws OrderDataException;
    
    /**
     * 
     * @param id
     * @return
     * @throws OrderDataException 
     */
    Order getOrderById(int id) throws OrderDataException;
    
    /**
     * 
     * @return
     * @throws OrderDataException 
     */
    List<Order> getAllOrders() throws OrderDataException;
    
    /**
     * 
     * @param original
     * @param updated
     * @throws OrderDataException 
     */
    void updateOrder(Order original, Order updated) 
            throws OrderDataException;
    
    /**
     * 
     * @param order
     * @throws OrderDataException 
     */
    void deleteOrder(Order order) throws OrderDataException;
    
    /**
     * creates a new order record.
     * @param order
     * @throws OrderDataException 
     */
    void createOrderRecord(Order order) throws OrderDataException;
    
    /**
     * updates an existing order recrod.
     * @param original
     * @throws OrderDataException 
     */
    void updateOrder(Order original) throws OrderDataException;
}
