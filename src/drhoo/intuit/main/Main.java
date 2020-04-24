package drhoo.intuit.main;

import org.eclipse.jetty.server.Server;

import drhoo.intuit.accountService.AccountServiceImpl;
import drhoo.intuit.base.MessageSystem;
import drhoo.intuit.frontend.FrontendImpl;
import drhoo.intuit.messageSystem.MessageSystemImpl;

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
