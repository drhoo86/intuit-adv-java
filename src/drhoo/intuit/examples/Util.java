package drhoo.intuit.examples;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public static String myTimeStamp () {
		return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").
				format(Calendar.getInstance().getTime());
	}
}
