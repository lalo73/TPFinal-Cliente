package filter;

import interfaces.IEmail;

import java.util.ArrayList;


public class CompoundOr extends Compound{
	
	//Toma dos reglas y las defince con un OR.	
public boolean satisfy(IEmail e){
		
		return this.getReglas().get(0).satisfy(e) | this.getReglas().get(1).satisfy(e);
		
	}
	

//Constructor de CompoundOr.
public CompoundOr(ArrayList<Rule> r) {
	super(r);
}	
	

}
