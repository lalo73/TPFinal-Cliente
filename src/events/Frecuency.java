package events;
/**
 * @Author: Flores Jorge
 */

import java.util.Calendar;



public abstract class Frecuency {
      private Calendar date = Calendar.getInstance();

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Frecuency(Calendar date) {
		this.date = date;
	}
	
	public abstract void nextDate();
	public boolean shouldAct(Calendar c) {
		return c.equals(this.getDate());
	}
}
