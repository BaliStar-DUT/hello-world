package yang.java.test;
/**
 * �Զ�����û���������쳣
 * @date 2015��9��22�� ����10:20:23
 * @author James Yang
 * @version 1.0
 * @since
 */
public class InvalidUserInputException extends Exception {
	private static final long serialVersionUID = 90001L;
	
	public InvalidUserInputException() {}

	public InvalidUserInputException(String message) {
		super(message);
	}
	
}
