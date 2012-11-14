package client;

public abstract class Different extends Rule {

	String dString;
	
	
	public boolean satisfy(String s){
		
		return s!=dString;
	}
	
	
	
}
