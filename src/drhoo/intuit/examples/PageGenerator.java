package drhoo.intuit.examples;

public class PageGenerator {
	
	static String getPage(String greeting, String body) {
		StringBuilder page = new StringBuilder("");
		StringBuilder header = new StringBuilder("");
		header.
			append("<!DOCTYPE html>").
			append("<html>").
			append("<head>").
			append("<meta charset=\"UTF-8\">").
			append("<title>");
				
		String title = "Intuit Java Course";
		
		header.
			append(title).
			append("</title>").
			append("</head>");
		
		page.append(header);
		
		page.
			append("<body onload='setInterval(function(){refresh()},1000)\n").
			append(" function refresh(){location.reload(true);}'>\n");
		
		if (greeting != null) {
			page.append("<h1>").append(greeting).append("</h1>\n");
		}	

		if (body != null) {
			page.append(body).append("\n");
		}	
		
		StringBuilder footer = new StringBuilder("<hr>\n");
		footer.append(Util.myTimeStamp());
		page.append(footer);
		
		page.
			append("</body>").
			append("</html>");
		
		return page.toString();
	}
}
