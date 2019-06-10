package models;

import java.util.*;
import java.text.SimpleDateFormat;

import io.ebean.*;

import javax.persistence.*;

@Entity
public class Anuncio extends Model {

    public static String CATEGORIA_PERIGOSA = "perigosa";
    public static String CATEGORIA_PESADA = "pesada";
    public static String CATEGORIA_GRANEL = "granel";
    public static String CATEGORIA_NEOGRANEL = "neogranel";

    public static int lastInsertedId = 1;


    public static String[] CATEGORIAS = {
            CATEGORIA_PERIGOSA,
            CATEGORIA_PESADA,
            CATEGORIA_GRANEL,
            CATEGORIA_NEOGRANEL
    };

    @Id
    public Integer id;
    public Integer usuario_id;
    public String titulo;
    public String categoria;
    public String descricao;
    public String origem ;
    public String destino;
    public Double peso;
    public Double valor;
    public Date data;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name="propostas")
    public List<Proposta> propostas = new ArrayList<Proposta>();

    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy hh:mm").format(this.data);
    }

    public static Finder<Integer, Anuncio> find = new Finder<>(Anuncio.class);

    public static List<Anuncio> filtro(String c, String v){
      List<Anuncio> anuncios = Anuncio.find.all();
      List<Anuncio> an = new ArrayList<Anuncio>();
      String busca = null;
      for(Anuncio anun: anuncios){
        switch(c){
          case "title": busca = anun.titulo.toLowerCase();break;
          case "cat": busca = anun.categoria.toLowerCase();break;
          case "cityo": busca = anun.origem.toLowerCase();break;
          case "cityd": busca = anun.destino.toLowerCase();break;
          default:busca = anun.titulo.toLowerCase();break;
        }

        if(busca.contains(v.toLowerCase()))
          an.add(anun);
      }
      return an;
    }

}
