package drhoo.intuit;

import org.eclipse.jetty.server.Server;

public class Main {
	public static void main(String[] args) throws Exception {
		MessageSystem ms = new MessageSystemImpl();
		
		FrontendImpl frontend = new FrontendImpl(ms);
		AccountServiceImpl accountService = new AccountServiceImpl(ms);
		
		(new Thread(frontend)).start();
		(new Thread(accountService)).start();

		Server server = new Server(8080);
        server.setHandler(frontend);
        
        server.start();
        server.join();
	}
}
