package nisum.java.test.models.exceptions;

public class ExistingUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7646201133300517659L;
    public ExistingUserException(String message) {
        super(message);
    }

}
