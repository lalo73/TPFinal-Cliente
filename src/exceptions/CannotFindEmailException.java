package exceptions;

@SuppressWarnings("serial")
public class CannotFindEmailException extends Exception{

	public CannotFindEmailException(String string) {
		super(string);
	}
	
	public CannotFindEmailException(){
		super();
	}

	
}


