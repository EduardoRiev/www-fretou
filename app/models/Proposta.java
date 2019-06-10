package models;

import java.util.*;
import java.text.SimpleDateFormat;

import io.ebean.*;

import javax.persistence.*;

@Entity
public class Proposta extends Model {

  public static String STATUS_ACEITA = "aceita";
  public static String STATUS_AGUARDANDO = "aguardando";
  public static String STATUS_RECUSADA = "recusada";

  @Id
  public Integer id;
  public String status;
  public String descricao;
  public Date data;
  public int usuario_id;
  @ManyToOne
  @Column(name = "anuncio_id")
  public Anuncio anuncio;

  public Proposta(int id, String status, String descricao, Date data, int usuario_id, Integer anuncio_id){
    this.status = status;
    this.usuario_id = usuario_id;
    this.descricao = descricao;
    this.data = data;
    this.anuncio = Anuncio.find.byId(anuncio_id);
  }

  public Proposta() {
    this.status = STATUS_AGUARDANDO;
  }

  public String getData(){
    String dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.data);
    return dt;
  }

  public void aceitar()
  {
    this.status = STATUS_ACEITA;
  }

  public void recusar()
  {
    this.status = STATUS_RECUSADA;
  }

  public Anuncio anuncio()
  {
    return anuncio;
  }

  public static Finder<Integer, Proposta> find = new Finder<>(Proposta.class);
}
