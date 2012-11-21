package client;

public class Different extends Rule {

	String dString;
	
	
	public boolean satisfy(IEmail e){
		
		return f.getField(e)!=dString;
	}


	public String getdString() {
		return dString;
	}


	public void setdString(String dString) {
		this.dString = dString;
	}
	
	public Different(String s,Field f){
		this.setdString(s);
		this.setF(f);
	}
	
	
	
}
