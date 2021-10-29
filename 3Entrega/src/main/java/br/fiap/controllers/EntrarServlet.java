package br.fiap.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Usuario;

/**
 * Servlet implementation class EntrarServlet
 */
@WebServlet("/entrar")
public class EntrarServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    UsuarioDAO dao = new UsuarioDAO();

    PrintWriter pw = response.getWriter();
    Usuario user = null;
    try {
       user = dao.buscarPorEmail(email,senha);
    }catch(Exception e) {
      System.out.println(e);
    }
    
    if(user == null) {
      pw.println("<html> <body> <h1> Nao existe nenhum usuario com esse email ou a senha está incorreta!</h1>"
          + "<a href=\"http://localhost:8080/3Entrega/\"> <button>Voltar</button> </a>");
    }
    
    if(user.getTipoUsuario().equalsIgnoreCase("administrador")) {
      
      List<Usuario> lista = dao.obterTodos();
      request.setAttribute("lista", lista);
      RequestDispatcher dispatcher = request.getRequestDispatcher("adm.jsp");
      dispatcher.forward(request, response);
      
    }else if(user.getTipoUsuario().equalsIgnoreCase("paciente")) {
      
      System.out.println("testando");
      request.setAttribute("usuario", user);
      RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
      dispatcher.forward(request, response);
      
    }

  }
}
