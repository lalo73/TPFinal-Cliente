package client;

import java.util.Calendar;

import interfaces.IEvent;

public abstract class Event implements IEvent {

	String notify;
	Frecuency frecuency;
	Calendar eventDate;
	Calendar today;
	
	
	public Calendar getToday(){
		return today;
	}
	public Calendar getEventDate() {
		return eventDate;
	}



	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}
	public String getNotify() {
		return notify;
	}



	public void setNotify(String notify) {
		this.notify = notify;
	}



	public Frecuency getFrecuency() {
		return frecuency;
	}



	public void setFrecuency(Frecuency frecuency) {
		this.frecuency = frecuency;
	}


	

	public Event(String notify, Frecuency frecuency ,Calendar eventDate) {
		super();
		this.notify = notify;
		this.today = Calendar.getInstance();
		this.frecuency = frecuency;
		this.eventDate = eventDate;
	}

   public void tomorrow(Client c){
	   /*
	    * Templated Method (?)
	    */
	   this.getToday().add(Calendar.DAY_OF_MONTH,1);
	   this.act(c,this.getToday());
   }

	protected abstract void act (Client c , Calendar d );
}