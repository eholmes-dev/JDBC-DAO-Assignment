
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
public class ShowOrdersHandler {
     /**
     * Show all order records.
     *
     * @param dao the Data Access Object
     */
    public static void handleTask(OrderDAO dao) {

        try {
            List<Order> orders = dao.getAllOrders();
            String title = "All Orders";
            UIHelper.showTitle(title);
            if(orders.isEmpty()){
                UIHelper.showMessage(
                        "There are no Order records.");
            } else {
                for (Order order : orders) {
                    UIHelper.showMessage(order.toString());
                }
            }
            
        } catch (OrderDataException ex) {
            UIHelper.showErrorMessage(ex.getMessage());
        }

    }
}
