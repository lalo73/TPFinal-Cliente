package client;

import java.util.Calendar;

public class WithNotification extends Event {

	public WithNotification(String notify, Frecuency frecuency,
			Calendar eventDate) {
		super(notify, frecuency, eventDate);
		// TODO Auto-generated constructor stub
	}

	
	protected void act(Client c, Calendar d) {
		if (this.getFrecuency().shouldAct(d)){
			c.sendNotifySMS(23123123,"event!!");
			this.getFrecuency().nextDate(d);
		}
		
	}

}