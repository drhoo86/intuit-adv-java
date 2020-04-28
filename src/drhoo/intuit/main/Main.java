package drhoo.intuit.main;

import drhoo.intuit.base.AuthService;
import drhoo.intuit.base.GameMechanics;
import drhoo.intuit.base.WebSocketService;
//import drhoo.intuit.chat.WebSocketChatServlet;
import drhoo.intuit.frontend.AuthServiceImpl;
import drhoo.intuit.frontend.GameServlet;
import drhoo.intuit.frontend.WebSocketGameServlet;
import drhoo.intuit.frontend.WebSocketServiceImpl;
import drhoo.intuit.mechanics.GameMechanicsImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        WebSocketService webSocketService = new WebSocketServiceImpl();
        GameMechanics gameMechanics = new GameMechanicsImpl(webSocketService);
        AuthService authService = new AuthServiceImpl();

        //for chat example
        //context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");

        //for game example
        //context.addServlet(new ServletHolder(new WebSocketGameServlet(authService, gameMechanics, webSocketService)), "/gameplay");
        context.addServlet(new ServletHolder(new GameServlet(gameMechanics, authService)), "/game.html");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        server.setHandler(handlers);

        server.start();

        //run GM in main thread
        gameMechanics.run();
    }
}
