package exception;


public class AutenticationException extends Exception{
	private static final long serialVersionUID = 1L;

	public AutenticationException() {
		super ("Login ou senha não encontrados");
	}

}
