package telBookApp.exception;

public class MyException extends Exception{
	private static final long serialVersionUID = 1;
	public MyException() {};
	public MyException(String message) {
		super(message);
	}
}
