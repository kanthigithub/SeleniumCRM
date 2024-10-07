package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		
		//capturing current date in required format
		
		Date dateObj = new Date();
		System.out.println(dateObj);
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = simple.format(dateObj);
		System.out.println(actDate);
		
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		
		String finalDate = simple.format(cal.getTime());
		System.out.println(finalDate);
		
		cal.add(Calendar.DAY_OF_MONTH, -10);
		System.out.println(simple.format(cal.getTime()));
		

	}

}
