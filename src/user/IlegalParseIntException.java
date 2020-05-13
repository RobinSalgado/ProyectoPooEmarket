package user;

public class IlegalParseIntException extends Exception{
	private static final long serialVersionUID = 1L;

	public IlegalParseIntException() {
		//Nombre que queremos que tenga la excepción.
		super("IlegalParseIntException");
	}

	public String toString() {
		return getMessage() + "\nNegative number found : " + this;
	}
	

}
