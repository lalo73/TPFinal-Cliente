package client;

import java.util.Calendar;

public class StateModifier extends Event {

	public StateModifier(String notify, Frecuency frecuency, Calendar eventDate) {
		super(notify, frecuency, eventDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void act(Client c, Calendar d) {
		
		if (this.getFrecuency().shouldAct(d)){
			// DEBE CAMBIAR EL ESTADO!!! c.getClientState().
			this.getFrecuency().nextDate(d);
		}
		
	}

}
