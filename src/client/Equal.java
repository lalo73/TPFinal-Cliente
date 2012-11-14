package client;

public abstract class Equal extends Rule {
	
	String eString;
	
	public boolean satisfy(String s){
		
		return s.equals(eString);
	}
	

}
