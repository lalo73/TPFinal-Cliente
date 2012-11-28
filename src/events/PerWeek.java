package events;

import java.util.Calendar;

public class PerWeek extends Frecuency{

	public PerWeek(Calendar nextdate) {
		super(nextdate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextDate(Calendar d) {
		this.getNextdate().add(Calendar.DAY_OF_MONTH, 7);
		
	}

}
