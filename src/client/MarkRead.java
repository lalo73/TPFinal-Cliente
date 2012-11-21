package client;

public class MarkRead extends Action {

	public void act(IEmail e,IClient c){
		
		e.setisReaded(true);
		
	  }
	
	
	
}
