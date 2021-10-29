package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Paciente;

public class PacienteDAO {

  private ResultSet rs;
  private PreparedStatement ps;
  private String sql;
  private Connection connection;
  
  
  public PacienteDAO() {
    connection = Conexao.conectar();
  }
  
  
  public void inserir(Paciente paciente) {
    sql = "insert into tb_paciente values (?,?,?,?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, paciente.getEmail());
      ps.setDouble(2, paciente.getAltura());
      ps.setString(3, paciente.getGenero());
      ps.setDouble(4, paciente.getPeso());
      ps.execute();
    }catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  public List<Paciente> obterTodos(){
    List<Paciente> lista = new ArrayList<>();
    sql = "select * from tb_paciente";
    try {
    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()) {
      lista.add(new Paciente(rs.getString("emailusuario"),rs.getDouble("altura"), rs.getString("genero"),rs.getDouble("peso")));
    }
    }catch(SQLException e) {
      System.out.println(e);
    }

    return lista;
  }
  
  public Paciente buscarPorEmail(String email) {
    Paciente paciente = null;
    sql = "select * from tb_paciente where emailusuario = ?";
    
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      rs = ps.executeQuery();
      if(rs.next()) {
        paciente = new Paciente(rs.getString("emailusuario"),rs.getDouble("altura"), rs.getString("genero"),rs.getDouble("peso"));
      }
    }catch(SQLException e) {
      System.out.println(e);
    }
    return paciente;
  }
  
  public void deletarTudo() {
    sql = "delete tb_paciente";
    try {
      ps= connection.prepareStatement(sql);
      ps.execute();
    }catch(SQLException e ) {
      System.out.println(e);
    }
  }

}
