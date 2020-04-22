package drhoo.intuit;

import org.eclipse.jetty.server.Server;

// lecture 2, task 3
public class Task2_3 {

	public static void main(String[] args) throws  Exception {

		Frontend frontend = new Frontend("Hello Server!", "Task3");
		(new Thread(frontend)).start();
		
		Server server = new Server(8080);
		server.setHandler(frontend);
		server.start();
		server.join();
		
	}

}
