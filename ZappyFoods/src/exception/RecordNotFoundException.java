package exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 *
 * 
 * @version 1.0
 * 
 *
 */

public class RecordNotFoundException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public RecordNotFoundException(String msg) {
        super(msg);

    }
}
