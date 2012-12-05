package events;
/**
 * @Author: Flores Jorge
 */

import interfaces.IEvent;

import java.util.Calendar;

import client.Client;
import exceptions.ExpiredEventException;
import exceptions.NoLoggedUserException;

public abstract class Event implements IEvent{
	private Calendar eventDate;
	private Frecuency frecuency;
	private String description;
	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}

	public Frecuency getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(Frecuency frecuency) {
		this.frecuency = frecuency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Event(Calendar eventDate, Frecuency frecuency, String description,int duration) {
		super();
		this.duration = duration;
		this.eventDate = eventDate;
		this.frecuency = frecuency;
		this.description = description;
	}
	
	public boolean valid(Calendar d) {
		/* The event is not valid if "d" is more greater than the EventDate plus 
		 * the duration
		 */
		Calendar p = this.getEventDate();
		p.add(Calendar.DAY_OF_MONTH, this.getDuration());
		return d.before(p);
	}
	
	public void act (Client c,Calendar d) throws NoLoggedUserException, ExpiredEventException{
		if (this.getFrecuency().shouldAct(d) && this.valid(d)){
			this.run(c);
		}
	}
  
}
