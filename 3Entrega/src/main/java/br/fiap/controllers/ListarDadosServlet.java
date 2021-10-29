package br.fiap.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarDadosServlet
 */
@WebServlet("/listarDados")
public class ListarDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  
	   String email = request.getParameter("user");

	   request.setAttribute("email", email);
     RequestDispatcher dispatcher = request.getRequestDispatcher("listarDados.jsp");
     dispatcher.forward(request, response);
	}

}
