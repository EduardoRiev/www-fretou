package models;

import java.util.*;

public class Proposta {

  public static String STATUS_ACEITA = "aceita";
  public static String STATUS_AGUARDANDO = "aguardando";
  public static String STATUS_RECUSADA = "recusada";

  public static int lastInsertedId = 1;

  public int id;
  public String status;
  public String descricao;
  public int usuario_id;
  public Anuncio anuncio;

  public Proposta(int id, String status, String descricao,int usuario_id, int anuncio_id){
    this.id = id + Proposta.lastInsertedId++;
    this.status = status;
    this.usuario_id = usuario_id;
    this.descricao = descricao;
    this.anuncio = Anuncio.findById(anuncio_id);
  }

  public Proposta() {
    this.status = STATUS_AGUARDANDO;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public void aceitar()
  {
    this.status = STATUS_ACEITA;
  }

  public void recusar()
  {
    this.status = STATUS_RECUSADA;
  }

  public String getStatus(){
    return this.status;
  }

  public void setUsuario_id(int usuario_id){
    this.usuario_id = usuario_id;
  }

  public int getUsuario_id(){
    return this.usuario_id;
  }

  public void setDescricao(String descricao) { this.descricao = descricao; }

  public String getDescricao() { return this.descricao; }

  public Anuncio anuncio()
  {
    return anuncio;
  }

  private static Set<Proposta> propostas;

  static {
    propostas = new HashSet<>();
    propostas.add(new Proposta(1, STATUS_AGUARDANDO, "Lorem Ipsum",1, 1) );
    propostas.add(new Proposta(3,STATUS_AGUARDANDO, "Lorem Ipsum", 1, 3) );
    propostas.add(new Proposta(46,STATUS_AGUARDANDO, "Lorem Ipsum", 1, 46) );
    propostas.add(new Proposta(16,STATUS_AGUARDANDO, "Lorem Ipsum", 1, 16) );
    propostas.add(new Proposta(543,STATUS_AGUARDANDO, "Lorem Ipsum", 1, 543) );
    propostas.add(new Proposta(21,STATUS_AGUARDANDO, "Lorem Ipsum", 1, 21) );
  }

  public static Set<Proposta> all() {
    return propostas;
  }

  public static Set<Proposta> filterByStatus(String status) {
    Set<Proposta> filtradas = new HashSet<>();
    for (Proposta proposta : propostas)
      if (status.equals(proposta.status))
        filtradas.add(proposta);

    return filtradas;
  }

  public static Proposta findById(int id) {

    for (Proposta proposta : propostas)
      if(proposta.id == id)
        return proposta;

      return null;
  }


}
