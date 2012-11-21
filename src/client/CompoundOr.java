package client;

import java.util.ArrayList;

public class CompoundOr extends Compound{
	
public boolean satisfy(IEmail e){
		
		return this.getReglas().get(0).satisfy(e) | this.getReglas().get(1).satisfy(e);
		
	}
	
public CompoundOr(ArrayList<Rule> r) {
	super(r);
	// TODO Auto-generated constructor stub
}	
	

}
