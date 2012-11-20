package client;

public class Different extends Rule {

	String dString;
	
	
	public boolean satisfy(String s){
		
		return s!=dString;
	}


	public String getdString() {
		return dString;
	}


	public void setdString(String dString) {
		this.dString = dString;
	}
	
	public Different(String s){
		this.setdString(s);
	}
	
}
