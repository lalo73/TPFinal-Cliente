package client;

import java.util.ArrayList;

public class CompoundOr extends Compound{
	
public boolean satisfy(String s){
		
		return this.getReglas().get(0).satisfy(s) | this.getReglas().get(1).satisfy(s);
		
	}
	
public CompoundOr(ArrayList<Rule> r) {
	super(r);
	// TODO Auto-generated constructor stub
}	
	

}
