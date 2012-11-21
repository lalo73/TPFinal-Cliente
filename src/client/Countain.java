package client;

public class Countain extends Rule {

	
	String cString;
	
	public boolean satisfy(IEmail e){
		
		return cString.contains(f.getField(e));
	}
	
	public String getcString() {
		return cString;
	}

	public void setcString(String cString) {
		this.cString = cString;
	}
	
	public Countain(String s,Field f){
		this.setcString(s);
		this.setF(f);
	}

}