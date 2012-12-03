package filter;

import interfaces.IEmail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date extends Field {

	
	//Se encarga y tomar y transformar a String la fecha del Head del Email. 
	public String getField(IEmail e) {

		Calendar fecha = e.getHead().getDate();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

		return formatDate.format(fecha);

	}	
	
}

