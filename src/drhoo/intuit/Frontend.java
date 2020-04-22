package drhoo.intuit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Frontend extends AbstractHandler implements Runnable {
	private static Logger log = Logger.getLogger(Frontend.class.getName());
	private String greeting;
	private String body;
	private int handleCount = 0;
			
	public Frontend() {
		this("Hello World");
	}
	
	public Frontend (String greeting) {
		this(greeting, null);
	}
	
	public Frontend(String greeting, String body) {
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
		handleCount++;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info(String.valueOf(handleCount));
			//System.out.println(String.valueOf(handleCount));
		}
	}

}
