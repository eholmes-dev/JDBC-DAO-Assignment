
package ech.dao.java.handler;

import ech.dao.java.order.Order;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDataException;
import ech.dao.java.ui.UIHelper;
import java.util.List;
/**
 *
 * @author ethan
 */
public class DeleteOrderHandler {
    
    public static void handleTask(OrderDAO dao) {

        UIHelper.showTitle("Delete an Order");

        try {
            List<Order> orders = dao.getAllOrders();
            
            String[] listOrders = new String[orders.size()];
            for (int i = 0; i < listOrders.length; i++) {
                listOrders[i] = (i + 1) + ") " + orders.get(i).toString();
            }
            String userChoice = UIHelper.showMenuOptions(
                    "Select an Order to Delete",
                     "Your Choice: ",
                     listOrders);
            try {
                int actualChoice = Integer.parseInt(userChoice) - 1;
                Order order = orders.get(actualChoice);
                dao.deleteOrder(order);
                UIHelper.showMessage("Order deleted.");
            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                UIHelper.showErrorMessage("No selection made.");
            }

           
        } catch (OrderDataException ex) {
            UIHelper.showErrorMessage(ex.getMessage());
        }
        
        UIHelper.showMessage("\nOrder record deleted.");
        UIHelper.pressEnterToContinue();
        

    }
    
}//end
