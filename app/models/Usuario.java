package models;

public class Usuario {

  protected int id;
  protected String tipo;
  protected String email;
  protected String senha;

  public Usuario(){

  }
  public Usuario(int id, String email, String senha, String tipo){
    this.id = id;
    this.tipo = tipo;
    this.email = email;
    this.senha = senha;
  }

  public void setId(int id){
    this.id = id;
  }
  public int getId(){
    return this.id;
  }

  public void setTipo(String tipo){
    this.tipo = tipo;
  }

  public String getTipo(){
    return this.tipo;
  }

  public String getEmail(){
    return this.email;
  }

  public void setEmail(String email){
    this.email = email;
  }
  public String getSenha(){
    return this.senha;
  }
  public void setSenha(String senha){
    this.senha = senha;
  }

}
