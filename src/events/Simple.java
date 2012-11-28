package events;

import java.util.Calendar;

import client.Client;

public class Simple extends Event{

	public Simple(String notify, Frecuency frecuency, Calendar eventDate) {
		super(notify, frecuency, eventDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void act(Client c, Calendar d) {
		// TODO Auto-generated method stub
		
	}

	
}


