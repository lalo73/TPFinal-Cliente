package client;

import java.util.ArrayList;

public class CompoundAnd extends Compound {

	
	public boolean satisfy(IEmail e){
		
		return this.getReglas().get(0).satisfy(e) & this.getReglas().get(1).satisfy(e);
		
	}

	public CompoundAnd(ArrayList<Rule> r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println("Lalo");
	}
	
	
}
