public class Usuario {

  private int id;
  private String tipo;


  public Usuario(int id, String tipo){
    this.id = id;
    this.tipo = tipo;
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

}
