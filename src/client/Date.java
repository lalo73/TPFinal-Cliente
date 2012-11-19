package client;

public class Date extends Field {
	
	public String getField(IEmail e){
		
		String fecha = e.getDate();
		
		return fecha;
		
		
	}

}
