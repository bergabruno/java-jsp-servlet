package br.fiap.entidade;

public class Paciente {

  private String email;
  private double altura;
  private double peso;
  private String genero;
  
  public Paciente(String email, double altura, String genero, double peso) {
    super();
    this.email = email;
    this.altura = altura;
    this.genero = genero;
    this.peso = peso;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public double getAltura() {
    return altura;
  }
  public void setAltura(double altura) {
    this.altura = altura;
  }
  public double getPeso() {
    return peso;
  }
  public void setPeso(double peso) {
    this.peso = peso;
  }
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }
  
  
}
