package events;

import java.util.Calendar;

public class EveryDay extends Frecuency {

	


	public EveryDay(Calendar nextdate) {
		super(nextdate);
		// TODO Auto-generated constructor stub
	}

	public void nextDate(Calendar d) {
		// TODO Auto-generated method stub
		this.getNextdate().add(Calendar.DAY_OF_MONTH, 1);
	}

}
