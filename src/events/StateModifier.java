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
	public boolean valid(Calendar d) {
		// TODO Auto-generated method stub
		/* The event is not valid if "d" is more greater than the EventDate plus 
		 * the duration
		 */
		Calendar p = this.getEventDate();
		p.add(Calendar.DAY_OF_MONTH, this.getDuration());
		return d.equals(p);
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
