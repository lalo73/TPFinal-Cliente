package events;

/**
 * @Author: Flores Jorge
 */
import java.util.Calendar;

import client.Client;
import exceptions.NoLoggedUserException;

public class Simple extends Event {

	public Simple(Calendar eventDate, Frecuency frecuency, String description,
			int duration) {
		super(eventDate, frecuency, description, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean valid(Calendar d) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void run(Client c) throws NoLoggedUserException {
		// TODO Auto-generated method stub
		
	}

}
