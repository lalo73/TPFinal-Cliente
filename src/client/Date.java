package client;

import interfaces.IEmail;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Date extends Field {
	
	public String getField(IEmail e){
		
		Calendar fecha = e.getHead().getDate();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		return formatDate.format(fecha);
		
		
	}

}

