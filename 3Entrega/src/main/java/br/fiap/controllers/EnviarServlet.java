package br.fiap.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.PacienteDAO;
import br.fiap.entidade.Paciente;

/**
 * Servlet implementation class EnviarServlet
 */
@WebServlet("/enviar")
public class EnviarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  double altura = Double.parseDouble(request.getParameter("altura"));
	  double peso = Double.parseDouble(request.getParameter("peso"));
	  String genero = request.getParameter("sex");
	  
	  System.out.println(genero);
	  
	  //TODO genero
	  String email = request.getParameter("user");
	  
	  PacienteDAO dao = new PacienteDAO();
	  
	  dao.inserir(new Paciente(email, altura, genero, peso));
	  
    PrintWriter pw = response.getWriter();

    
    pw.println("<html> <body> <h1>Dados salvos com sucesso!</h1>"
        + "<a href=\"http://localhost:8080/3Entrega\"> <button>Voltar</button> </a>");
	}

}
