package client;

public class Countain extends Rule {

	
	String cString;
	
	public boolean satisfy(String s){
		
		return s.contains(cString);
	}
	
	public Countain(String s){
		this.setcString(s);
	}
	


	public String getcString() {
		return cString;
	}

	public void setcString(String cString) {
		this.cString = cString;
	}

}