package br.fiap.entidade;

public class Usuario {

  private String nome;
  
  private String email;
  
  private String senha;
  
  private String tipoUsuario;

  public Usuario(String email, String nome, String senha, String tipoUsuario) {
    super();
    this.email = email;
    this.nome = nome;
    this.senha = senha;
    this.tipoUsuario = tipoUsuario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }
  
}
