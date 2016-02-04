import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateActuelle {
    
    
  public static void main(String[] args) {

	   GregorianCalendar dateFormat = new GregorianCalendar();
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(GregorianCalendar.format(date));
	  
	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   System.out.println(dateFormat.format(cal.getTime()));

  }
}
