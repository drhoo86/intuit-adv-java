package lecture1;

import org.eclipse.jetty.server.Server;

public class Task3 {

	public static void main(String[] args) throws  Exception {
		Server server = new Server(8080);
		server.setHandler(new PageHandler("Hello Server!", "Task3"));
		server.start();
		server.join();
	}

}
