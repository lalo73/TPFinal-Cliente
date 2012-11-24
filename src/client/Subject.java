package client;

public class Subject extends Field {
	
	
	public String getField(IEmail e){
		
		return e.getHead().getSubject();
	}

}
