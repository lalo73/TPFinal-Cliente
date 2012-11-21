package client;

public class Equal extends Rule {
	
	String eString;
	
	public boolean satisfy(IEmail e){
		
		return eString.equals(f.getField(e));
	}

	public String geteString() {
		return eString;
	}

	public void seteString(String eString) {
		this.eString = eString;
	}
	

	
	public Equal(String s,Field f){
		this.seteString(s);
		this.setF(f);
	}
	
}
