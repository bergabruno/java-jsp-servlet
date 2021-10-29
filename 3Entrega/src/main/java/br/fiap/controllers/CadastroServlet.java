package br.fiap.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Usuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario(email, nome, senha, "paciente");
		//mudar aqui para ser administrador
	
   
		UsuarioDAO dao = new UsuarioDAO();
		dao.inserir(user);
		
		PrintWriter pw = response.getWriter();
    
    pw.println("<html> <body> <h1>Usuario " + nome +  " cadastrado com sucesso </h1>"
        + "<a href=\"http://localhost:8080/3Entrega/\"> <button>Voltar</button> </a>");
		
	}

}
