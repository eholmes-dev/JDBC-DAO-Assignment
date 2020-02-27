
package ech.dao.java.handler;

import ech.dao.java.order.Order;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDataException;
import ech.dao.java.ui.UIHelper;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author ethan
 */
public class UpdateOrderHandler {
    
    /**
     *
     * @param dao
     */
    //@Override
    public static void handleTask(OrderDAO dao) {

        UIHelper.showTitle("Update an Order");

        try {
            List<Order> orders = dao.getAllOrders();
            // gets original order
            String[] listOrders = new String[orders.size()];
            for (int i = 0; i < listOrders.length; i++) {
                listOrders[i] = (i + 1) + ") " + orders.get(i).toString();
            }
            String userChoice = UIHelper.showMenuOptions(
                    "Select an order to update",
                    "Your Choice: ",
                    listOrders);
            try {
                int actualChoice = Integer.parseInt(userChoice)-1; //-1;
                Order order = orders.get(actualChoice);
                updateOrder(dao, order);
                UIHelper.showMessage("Order updated");
            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                UIHelper.showErrorMessage("No order selected");
            }

            
        } catch (OrderDataException ex) {
            UIHelper.showErrorMessage(ex.getMessage());
        }

        UIHelper.showMessage("\nDone updating");
        UIHelper.pressEnterToContinue();
    }

    
    private static void updateOrder(OrderDAO dao, Order order) throws OrderDataException {
        
        String msgUpdatingOrder = "Updating Order: " + order;
        String msgOrderNumber = "Order Number: " + order.getOrderNumber();
        String msgCurrentOrderDate = "Current Order Date: " + order.getOrderDate();
        String msgCurrentVendorId = "Current Vendor Id: " + order.getVendorId();
        
        
        String promptEnterOrderNumber = "Enter the new Order Number: ";
        String prompEnterOrderDate = "Enter the new Order Date: ";
        String promptVendorId = "Enter the new Vendor Id: ";
        

        
        Order updated = new Order(order);
        UIHelper.showMessage(msgUpdatingOrder);
        //UIHelper.showMessage(msgOrderNumber);

        
        UIHelper.showMessage(msgOrderNumber);
        int updatedOrderNumber = UIHelper.getInt(promptEnterOrderNumber,1,999999999, "Not valid... please re-enter: ");
        updated.setOrderNumber(updatedOrderNumber);

        
        UIHelper.showMessage(msgCurrentOrderDate);
        LocalDate updatedOrderDate = UIHelper.getDate(prompEnterOrderDate);
        updated.setOrderDate(updatedOrderDate);
        

        UIHelper.showMessage(msgCurrentVendorId);
        int updatedVendorId = UIHelper.getInt(promptVendorId,1,99999999,"not valid.");
        updated.setVendorId(updatedVendorId);

        // update
        dao.updateOrder(order, updated);
    }

}//end
