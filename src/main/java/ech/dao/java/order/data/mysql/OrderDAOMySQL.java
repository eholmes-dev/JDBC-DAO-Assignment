
package ech.dao.java.order.data.mysql;


import ech.dao.java.order.Order;
import ech.dao.java.order.data.OrderDAO;
import ech.dao.java.order.data.OrderDataException;
import static ech.dao.java.ui.UIHelper.getDate;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ethan
 */
public class OrderDAOMySQL implements OrderDAO{
    public static final String DEFAULT_URL = "localhost";

    /**
     * The default port for MySQL is 3306
     */
    public static final int DEFAULT_PORT = 3306;
    
    public Date convertToDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
   /**
    * converts the date to a LocalDate type.
    * @param dateToConvert
    * @return 
    */ 
   public LocalDate convertToLocalDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}
    
   /**
    * builds the connection to the database.
    * @return
    * @throws SQLException 
    */
    private Connection buildConnection() throws SQLException {
        String databaseUrl = "DESKTOP-CKGNBIH\\SQLEXPRESS";
        int databasePort = 3306;
        String databaseName = "OrderSystem";
        String userName ="DAOUser";
        String password = "password";

        /**
         * Build the connection string to be used for the connection
         */
        String connectionString = "jdbc:mysql://" + databaseUrl + ":"
                + databasePort
                + "/" + databaseName
                + "?useSSL=false"
                +"&user=" + userName + "&password="
                + password;

        return DriverManager.getConnection(connectionString);
    }

    /**
     * steps for creating an order record
     * @param order
     * @throws OrderDataException 
     */
    @Override
    public void createOrderRecord(Order order) throws OrderDataException {
        try{
            Connection conn = buildConnection();
            CallableStatement callableStatement
                    = conn.prepareCall("CALL sp_insert_into_orderrecord(?,?,?,?);");
            callableStatement.setInt(1, order.getId());
            callableStatement.setInt(2, order.getOrderNumber());
            callableStatement.setDate(3, (java.sql.Date) convertToDate(order.getOrderDate()));
            callableStatement.setInt(4, order.getVendorId());

            callableStatement.execute();

        } catch(SQLException ex){
            throw new OrderDataException(ex);
        }
    }


    
    @Override
    public List<Order> getAllOrders() throws OrderDataException {
        List<Order> orders = new ArrayList<>();
        try{
            Connection conn = buildConnection();
            CallableStatement callableStatement
                    = conn.prepareCall("CALL sp_get_all_orderrecord_items;");

            ResultSet resultSet = callableStatement.executeQuery();
            int orderId;
            int orderNumber;
            LocalDate orderDate;
            int vendorId;
            while(resultSet.next()){
                orderId =resultSet.getInt("order_id");
                orderNumber = resultSet.getInt("order_number");
                orderDate = convertToLocalDate(resultSet.getDate("order_date"));
                vendorId = resultSet.getInt("Model_Year");
                orders.add(new Order(orderId, orderNumber, orderDate, vendorId));
            }


        } catch(SQLException ex){
            throw new OrderDataException(ex);
        }
        return orders;
    }

    
    @Override
    public void updateOrder(Order original) throws OrderDataException {
        try{
            Connection conn = buildConnection();
            CallableStatement callableStatement
                    = conn.prepareCall("CALL sp_update_orderrecordItems(?,?,?,?);");
            callableStatement.setInt(1, original.getId());
            callableStatement.setInt(2, original.getOrderNumber());
            callableStatement.setDate(3, (java.sql.Date) convertToDate(original.getOrderDate()));
            callableStatement.setInt(4, original.getVendorId());
            

            callableStatement.execute();

        } catch(SQLException ex){
            throw new OrderDataException(ex);
        }
    }

 
    @Override
    public void deleteOrder(Order order) throws OrderDataException {
        try{
            Connection conn = buildConnection();
            CallableStatement callableStatement
                    = conn.prepareCall("CALL sp_delete_fromorderrecord(?);");
            callableStatement.setInt(1, order.getId());
            

        } catch(SQLException ex){
            throw new OrderDataException(ex);
        }
    }

    @Override
    public void createOrder(Order order) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrderById(int id) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order original, Order updated) throws OrderDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
}
