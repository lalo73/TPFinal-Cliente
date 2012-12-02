package events;
/**
 * @Author: Flores Jorge
 */
import java.util.Calendar;

public class PerMonth extends Frecuency{

	public PerMonth(Calendar date) {
		super(date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextDate() {
		this.getDate().add(Calendar.DAY_OF_MONTH,30);
		
	}

	

}
