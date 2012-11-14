package client;

public class Date extends Field {
	
	public String getCampo(IEmail e){
		
		String fecha = e.getDate();
		
		return fecha;
		
		
	}

}
