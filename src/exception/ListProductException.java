package exception;

public class ListProductException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义程序序列化ID。
	//序列化ID，相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性，在程序版本升级时避免程序报出版本不一致的错误。

	public ListProductException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ListProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ListProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ListProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
