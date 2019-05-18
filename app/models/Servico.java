package models;

public class Servico {

  private int id;
  private int usuario_id;

  public Servico(int id, int usuario_id){
    this.id = id;
    this.usuario_id = usuario_id;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public void setUsuario_id(int usuario_id){
    this.usuario_id = usuario_id;
  }

  public int getUsuario_id(){
    return this.usuario_id;
  }

}
