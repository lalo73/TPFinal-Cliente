package client;

public class Equal extends Rule {
	
	String eString;
	
	public boolean satisfy(String s){
		
		return s.equals(eString);
	}

	public String geteString() {
		return eString;
	}

	public void seteString(String eString) {
		this.eString = eString;
	}
	

	
	public Equal(String s){
		this.seteString(s);
	}
	
}
