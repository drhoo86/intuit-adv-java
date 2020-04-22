package drhoo.intuit;

import org.eclipse.jetty.server.Server;

// lecture 1, task 3
public class Task1_3 {

	public static void main(String[] args) throws  Exception {
		Server server = new Server(8080);
		server.setHandler(new PageHandler("Hello Server!", "Task3"));
		server.start();
		server.join();
	}

}
