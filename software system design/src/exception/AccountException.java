package exception;
/*deal with Runtime Exception*/

public class AccountException extends RuntimeException {
	/**
	 * 
	 */

	public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }
}
