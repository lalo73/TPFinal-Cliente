package filter;

import interfaces.IEmail;

import java.util.ArrayList;


public class CompoundAnd extends Compound {

	//Toma dos reglas y las defince con un AND.
	public boolean satisfy(IEmail e){
		
		return this.getReglas().get(0).satisfy(e) & this.getReglas().get(1).satisfy(e);
		
	}

	
	//Constructor de CompoundAnd
	public CompoundAnd(ArrayList<Rule> r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
