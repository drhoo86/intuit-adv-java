package drhoo.intuit;

import org.eclipse.jetty.server.Server;

// lecture 1, task 2
public class Task1_2 {

	public static void main(String[] args) throws  Exception {
		Server server = new Server(8080);
		server.setHandler(new HelloHandler("Hello Server!"));
		server.start();
		server.join();
	}

}
