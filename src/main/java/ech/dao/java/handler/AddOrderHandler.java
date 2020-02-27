
package ech.dao.java.handler;

import ech.dao.java.order.Order;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDataException;
import ech.dao.java.ui.UIHelper;
import java.time.LocalDate;
/**
 *
 * @author ethan
 */
public class AddOrderHandler {
    public static void handleTask(OrderDAO dao){
        
        // order number
        int orderNumber = 
                UIHelper.getInt("Enter the OrderNumber: ",1,999999999, "Not valid... please re-enter: ");
        // order date
        LocalDate orderDate = 
                UIHelper.getDate("Enter the Order Date: ");
        // vendor id
        int vendorId = 
                UIHelper.getInt("Enter the VendorId: ",1,999999999, "Not valid... please re-enter: ");
        
        Order order = new Order(orderNumber, orderDate, vendorId);
        try{
            dao.createOrder(order);
        } catch (OrderDataException ex) {
            UIHelper.showErrorMessage(
                    "ERROR: " + ex.getMessage());
        }
        
        
    }
}
