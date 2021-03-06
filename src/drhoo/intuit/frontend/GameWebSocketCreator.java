package drhoo.intuit.frontend;

import drhoo.intuit.base.AuthService;
import drhoo.intuit.base.GameMechanics;
import drhoo.intuit.base.WebSocketService;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;


public class GameWebSocketCreator implements WebSocketCreator {
    private AuthService authService;
    private GameMechanics gameMechanics;
    private WebSocketService webSocketService;

    public GameWebSocketCreator(AuthService authService,
                                GameMechanics gameMechanics,
                                WebSocketService webSocketService) {
        this.authService = authService;
        this.gameMechanics = gameMechanics;
        this.webSocketService = webSocketService;
    }

    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
        String sessionId = req.getHttpServletRequest().getSession().getId();
        String name = authService.getUserName(sessionId);
        return new GameWebSocket(name, gameMechanics, webSocketService);
    }
}
