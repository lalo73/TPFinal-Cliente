package client;

public class Delete extends Action {

	
	public void act(IEmail e,IClient c){
		
		c.remove(e);
		
	}
	
	
	
}
