package exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 *
 * 
 * @version 1.0
 * 
 *
 */

public class DatabaseException extends Exception {

    /**
     * @param msg
     *            : Error message
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}