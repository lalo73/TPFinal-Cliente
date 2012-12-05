package events;

/**
 * @Author: Flores Jorge
 */
import java.util.Calendar;

import client.Client;
import exceptions.NoLoggedUserException;

public class StateModifier extends Event {

	public StateModifier(Calendar eventDate, Frecuency frecuency,
			String description, int duration) {
		super(eventDate, frecuency, description, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run( Client c) throws NoLoggedUserException {
		// TODO Auto-generated method stub
		/*
		 *  Cliente Change State !!
		 */
		c.changeToHolidayState(2333);
		c.changeToHolidayState("On Holidays");
		this.getFrecuency().nextDate();
	}

	
}
