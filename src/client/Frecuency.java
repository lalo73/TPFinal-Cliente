package client;

import java.util.Calendar;



public  abstract class Frecuency {
   
	Calendar nextdate = Calendar.getInstance();

	public Calendar getNextdate() {
		return nextdate;
	}

	public void setNextdate(Calendar object) {
		this.nextdate = object;
	}
	
	
	
	
	public Frecuency(Calendar nextdate) {
		super();
		this.nextdate = nextdate;
	}

	public boolean shouldAct(Calendar d) {
		
		return (d.equals(this.getNextdate()));
	}
	public abstract void nextDate(Calendar d);
	
}
