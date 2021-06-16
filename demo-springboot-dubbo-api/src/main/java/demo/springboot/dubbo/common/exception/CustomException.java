package demo.springboot.dubbo.common.exception;

/**
 * 自定义异常
 *
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		
	}
	
	public CustomException(String message) {
        super(message);
	}
	
}
