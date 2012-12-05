package filter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BORRAR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(date);
	      SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");//you can use any format that you want, for example:("yyyy/MM/dd")
	      String s = SDF.format(date);
	      System.out.print(s);
	      }

}
