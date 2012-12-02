package events;
/**
 * @Author: Flores Jorge
 */

import java.util.Calendar;

public abstract class Frecuency {
      private Calendar date;

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
		return c.before(this.getDate()) || c.equals(this.getDate());
	}
}
