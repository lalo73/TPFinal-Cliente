package client;

public abstract class Countain extends Rule {

	
	String cString;
	
	public boolean satisfy(String s){
		
		return s.contains(cString);
	}
	
	
	
}
