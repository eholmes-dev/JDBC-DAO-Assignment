
package ech.dao.java.order.data;

import ech.dao.java.order.data.csv.CSVOrderDAO;
import ech.dao.java.order.data.mysql.OrderDAOMySQL;

/**
 *
 * @author ethan
 */
public class OrderDAOFactory {
    /**
     * 
     */
    private static final String DAO_TYPE = "csv";
    
    /**
     * 
     */
    private static OrderDAOFactory instance;

    /**
     * 
     */
    private OrderDAOFactory() {
    }

    /**
     * gets an instance of new OrderDAOFactory()
     * @return 
     */
    public static OrderDAOFactory getInstance() {
        if (null == instance) {
            instance = new OrderDAOFactory();
        }
        return instance;
    }
    
    /**
     * gets the specified type of orderDAO
     * @return 
     */
    public OrderDAO getOrderDAO(){
        OrderDAO dao = null;
        switch(DAO_TYPE){
            case "csv":
                dao = new CSVOrderDAO();
                break;
            case "xml":
                // xml?
                break;
            case "MYSQL":
                dao = new OrderDAOMySQL();
                break;
            case "SQL_SERVER":
                break;
        }
        return dao;
    }
}
