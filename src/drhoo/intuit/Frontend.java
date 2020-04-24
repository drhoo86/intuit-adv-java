package drhoo.intuit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

public interface Frontend {

	public abstract void run();

	public abstract Address getAddress();

	public abstract void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;

	public abstract void setId(String name, Integer id);

}