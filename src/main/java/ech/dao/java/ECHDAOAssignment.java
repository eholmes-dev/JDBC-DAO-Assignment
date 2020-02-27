
package ech.dao.java;

import ech.dao.java.handler.AddOrderHandler;
import ech.dao.java.handler.DeleteOrderHandler;
import ech.dao.java.handler.ShowOrdersHandler;
import ech.dao.java.handler.UpdateOrderHandler;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDAOFactory;
import ech.dao.java.order.data.OrderDataException;
import ech.dao.java.ui.UIHelper;
/**
 *
 * @author ethan
 */
public class ECHDAOAssignment {
    /**
     * Begin
     *
     * @param args
     */
    public static void main(String[] args) {

        OrderDAO dao = 
                OrderDAOFactory.getInstance().getOrderDAO();
        
        String title = "Order DAO Assignment";
        String prompt = "Your choice: ";
        String errorMessage = "Invalid Option.  Try again.";
        String[] options = {
             "1) Add an Order",
             "2) Show All Orders",
             "3) Update an Order",
             "4) Delete an Order", 
             "5) Exit"
        };
        
        String userChoice;
        boolean working = true;
        while(working){
            userChoice = 
                    UIHelper.getUserChoice(title, prompt, options);
            switch(userChoice){
                case "1":
                    // Add Order
                    AddOrderHandler.handleTask(dao);
                    break;
                case "2":
                    // show all Orders
                    ShowOrdersHandler.handleTask(dao);
                    break;
                case "3":
                    UpdateOrderHandler.handleTask(dao);
                    break;
                case "4":
                    DeleteOrderHandler.handleTask(dao);
                    break;
                case "5":
                    working = false;
                    break;
                default:
                    UIHelper.showErrorMessage(errorMessage);
            }
        }
        UIHelper.showMessage("Program Done.");
    }//end main
   
}//end
