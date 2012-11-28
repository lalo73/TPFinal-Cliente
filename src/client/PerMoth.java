package client;

import java.util.Calendar;

public class PerMoth extends Frecuency {

	public PerMoth(Calendar nextdate) {
		super(nextdate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextDate(Calendar d) {
		this.getNextdate().add(Calendar.DAY_OF_MONTH,30 );
		
	}
	

}
