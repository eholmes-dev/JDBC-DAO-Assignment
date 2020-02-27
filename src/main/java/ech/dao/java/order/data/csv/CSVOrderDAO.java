
package ech.dao.java.order.data.csv;

import ech.dao.java.order.Order;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Ethan Holmes
 */
public class CSVOrderDAO implements OrderDAO{
    /**
     * The name of the CSV file.
     */
    private static final String FILE_NAME = "order.csv";
    
    /**
     * The highest Order Record ID currently.
     */
    private static int HIGHEST_ID = -1;
    
    /**
     * The ArrayList that maintains the working copy of 
     * the data.
     */
    private ArrayList<Order> orders;
    
    /**
     * Write the orders
     */
    private void saveData() throws OrderDataException{
        StringBuilder sb;
        try(PrintWriter writer = new PrintWriter(FILE_NAME)){
            for (Order order : orders) {
                sb  = new StringBuilder();
                sb.append(order.getId());
                sb.append(",");
                sb.append(order.getOrderNumber());
                sb.append(",");
                sb.append(order.getOrderDate().toString());
                sb.append(",");
                sb.append(order.getVendorId());
                writer.println(sb.toString());
                        
            }
        } catch(FileNotFoundException fnfe){
            throw new OrderDataException(fnfe);
        }
        
    }
    
    /**
     * Read the data from the CSV file into the ArrayList.
     * @throws ech.dao.java.order.data.OrderDataException
     */
    public void loadData() throws OrderDataException{
        ArrayList<Order> list = new ArrayList<>();
        String line;
        String[] fields;
        Order order;
        int id;
        LocalDate orderDate;
        int lineCount = 0;
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            while(in.hasNextLine()){
                lineCount++;
                line = in.nextLine();
                fields = line.split(",");
                // First field is ID
                try{
                    id = Integer.parseInt(fields[0]);
                } catch(NumberFormatException nfe){
                    throw new OrderDataException(
                            nfe.getMessage() 
                                    + " Line Number: " + lineCount);
                }

                try{
                    orderDate = LocalDate.parse(fields[2]);
                } catch(DateTimeException dte){
                    throw new OrderDataException(
                            dte.getMessage() 
                                    + " Line Number: " + lineCount);
                }
                if(id > HIGHEST_ID){
                    HIGHEST_ID = id;
                }
                order = new Order(id, Integer.parseInt(fields[1]), orderDate, Integer.parseInt(fields[3]));
                list.add(order);
            }
        } catch(IOException ioe){
            throw new OrderDataException(ioe);
        }
        orders = list;
    }
    
    /**
     *read data
     */
    private void verifyData() throws OrderDataException{
        if(null == orders){
            loadData();
        }
    }

    /**
     * 
     * @param order
     * @throws OrderDataException 
     */
    @Override
    public void createOrder(Order order) throws OrderDataException {
        verifyData();
        
        order.setId(++HIGHEST_ID);
        
        orders.add(order);
        
        saveData();
    }

    @Override
    public Order getOrderById(int id) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return
     * @throws OrderDataException 
     */
    @Override
    public List<Order> getAllOrders() throws OrderDataException {
        verifyData();
        ArrayList<Order> list = new ArrayList<>();
        for (Order order : orders) {
            list.add(new Order(order));
        }
        list.remove(0);
        return list;
    }
    
    /**
     * update logic for updating an existing order record.
     * @param original
     * @param updated
     * @throws OrderDataException 
     */
    @Override
    public void updateOrder(Order original, Order updated) throws OrderDataException {
        verifyData();
        
        Order foundOrder = null;
        for (Order order : orders) {
            if(order.getId() == original.getId()){
                //matched
                foundOrder = order;
                System.out.println("Order FOUDN!!!" + foundOrder.toString());
            }
        }
        if(null == foundOrder){
            // no match
            System.out.println(original.toString());
            throw new OrderDataException("Record not found.");
        }
        // If no error, update all but the unique identifier
        foundOrder.setId(original.getId());
        foundOrder.setOrderNumber(updated.getOrderNumber());
        foundOrder.setOrderDate(updated.getOrderDate());
        foundOrder.setVendorId(updated.getVendorId());
        saveData();
    }
    
    /**
     * delete logic for deleting an existing order.
     * @param order
     * @throws OrderDataException 
     */
    @Override
    public void deleteOrder(Order order) throws OrderDataException {
        deleteOrder(order.getOrderNumber());
    }
    //override?
    public void deleteOrder(int orderNumber) throws OrderDataException {
        verifyData();
        for (Order order : orders) {
            if(order.getOrderNumber()==(orderNumber)){
                orders.remove(order);
                break;
            }
        }
    }
    
    /**
     * Override not implemented.
     * @param order
     * @throws OrderDataException 
     */
    @Override
    public void createOrderRecord(Order order) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * override not implemented.
     * @param original
     * @throws OrderDataException 
     */
    @Override
    public void updateOrder(Order original) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end
