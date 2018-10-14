package br.com.cinqtech.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author Hugo Leonardo
 *
 */
public class AbstractFilter {

	public AbstractFilter() {
	}

	protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login");
		dispatcher.forward(request, response);
	}
	
	protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("acessoNegado");
		dispatcher.forward(request, response);
	}
}
