package exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 *
 * 
 * @version 1.0
 * 
 *
 */

public class DuplicateRecordException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}