package drhoo.intuit.frontend;

import drhoo.intuit.base.AuthService;
import drhoo.intuit.base.GameMechanics;
import drhoo.intuit.utils.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameServlet extends HttpServlet {

    private GameMechanics gameMechanics;
    private AuthService authService;

    public GameServlet(GameMechanics gameMechanics, AuthService authService) {
        this.gameMechanics = gameMechanics;
        this.authService = authService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();
        String name = request.getParameter("name");
        String safeName = name == null ? "NoName" : name;
        authService.saveUserName(request.getSession().getId(), name);
        pageVariables.put("myName", safeName);

        response.getWriter().println(PageGenerator.getPage("", null));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
