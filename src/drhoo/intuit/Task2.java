package drhoo.intuit;

import org.eclipse.jetty.server.Server;

public class Task2 {

	public static void main(String[] args) throws  Exception {
		Server server = new Server(8080);
		server.setHandler(new HelloHandler("Hello Server!"));
		server.start();
		server.join();
	}

}
