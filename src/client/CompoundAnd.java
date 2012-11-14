package client;

public class CompoundAnd extends Compound {

	
	public boolean satisfy(String s){
		
		return this.getReglas().get(0).satisfy(s) & this.getReglas().get(1).satisfy(s);
		
	}
	
	
	
	
}
