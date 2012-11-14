package client;

public class MoveToFolder extends Action {


	Folder f;
	
	
	
	public Folder getF() {
		return f;
	}



	public void setF(Folder f) {
		this.f = f;
	}



	public void act(IEmail e,IClient c){
		
	c.moveToFolder(e,getF());
		
	}
	
	
}
