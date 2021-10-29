package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Usuario;

public class UsuarioDAO {

  private ResultSet rs;
  private PreparedStatement ps;
  private String sql;
  private Connection connection;
  
  
  public UsuarioDAO() {
    connection = Conexao.conectar();
  }
  
  
  public void inserir(Usuario usuario) {
    sql = "insert into tb_usuario values (?,?,?,?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, usuario.getEmail());
      ps.setString(2, usuario.getNome());
      ps.setString(3, usuario.getSenha());
      ps.setString(4, usuario.getTipoUsuario());
      ps.execute();
    }catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public List<Usuario> obterTodos(){
    List<Usuario> lista = new ArrayList<>();
    sql = "select * from tb_usuario";
    try {
    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()) {
      lista.add(new Usuario(rs.getString("email"),rs.getString("nome"), 
          rs.getString("senha"),rs.getString("tipodeusuario")));
    }
    }catch(SQLException e) {
      System.out.println(e);
    }

    return lista;
  }
  
  public Usuario buscarPorEmail(String email,String senha) {
    Usuario usuario = null;
    sql = "select * from tb_usuario where email = ? and senha = ?";
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, senha);
      rs = ps.executeQuery();
      if(rs.next()) {
        usuario = new Usuario(rs.getString("email"),rs.getString("nome"), 
            rs.getString("senha"),rs.getString("tipodeusuario"));
      }
    }catch(SQLException e) {
      System.out.println(e);
    }
    return usuario;
  }
  
  public Usuario buscarSoPorEmail(String email) {
    Usuario usuario = null;
    sql = "select * from tb_usuario where email = ? ";
    
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      rs = ps.executeQuery();
      if(rs.next()) {
        usuario = new Usuario(rs.getString("email"),rs.getString("nome"), 
            rs.getString("senha"),rs.getString("tipodeusuario"));
      }
    }catch(SQLException e) {
      System.out.println(e);
    }
    return usuario;
  }
  
  public void deletarTudo() {
    sql = "delete tb_usuario";
    try {
      ps= connection.prepareStatement(sql);
      ps.execute();
    }catch(SQLException e ) {
      System.out.println(e);
    }
  }

}
