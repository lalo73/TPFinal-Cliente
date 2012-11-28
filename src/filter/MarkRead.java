package filter;

import interfaces.IClient;
import interfaces.IEmail;

public class MarkRead extends Action {
	
	boolean exclusive;

	public boolean act(IEmail e,IClient c){
		
		e.setReaded(true);
		return false;
	}

	
	
	public boolean exclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}
	
	
	public MarkRead(boolean b){
		
		this.setExclusive(b);
	}
	
}
