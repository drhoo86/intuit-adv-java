package drhoo.intuit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	static String myTimeStamp () {
		return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").
				format(Calendar.getInstance().getTime());
	}
}
