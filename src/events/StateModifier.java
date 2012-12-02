package events;

/**
 * @Author: Flores Jorge
 */
import java.util.Calendar;

import client.Client;

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
	public void run( Client c) {
		// TODO Auto-generated method stub
		/*
		 *  Cliente Change State !!
		 */
		c.changeTo();
		this.getFrecuency().nextDate();
	}
 // UN PROBLEMA DE INTERPRETACION QUE ACLARAR PARA CUANDO DE DEBE VOLVER DE LAS VACACIONES
	
}
