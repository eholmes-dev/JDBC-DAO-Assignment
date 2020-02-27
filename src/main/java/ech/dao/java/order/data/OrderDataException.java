
package ech.dao.java.order.data;

/**
 * Custom OrderDataException.
 * @author ethan
 */
public class OrderDataException extends Exception{
    public OrderDataException() {
    }

    public OrderDataException(String message) {
        super(message);
    }

    public OrderDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDataException(Throwable cause) {
        super(cause);
    }

    public OrderDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
