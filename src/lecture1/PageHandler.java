package lecture1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class PageHandler extends AbstractHandler {

	String greeting;
	String body;
	
	public PageHandler() {
		this("Hello World");
	}
	
	public PageHandler (String greeting) {
		this(greeting, null);
	}
	
	public PageHandler(String greeting, String body) {
		this.greeting = greeting;
		this.body = body;
	}



	@Override
	public void handle( String target, 
						Request baseRequest, 
						HttpServletRequest request,
						HttpServletResponse response) throws IOException, 
							ServletException {
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.println(PageGenerator.getPage(greeting, body));
		baseRequest.setHandled(true);
	}

}
