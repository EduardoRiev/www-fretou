package models;

import java.util.*;

import java.text.SimpleDateFormat;

import io.ebean.*;

import javax.persistence.*;

@Entity
public class Usuario{

  @Id
  public static String TIPO_CONTRATANTE = "contratante";
  public static String TIPO_FRETISTA = "fretista";

  private int id;
  private String tipo;
  private String nome;

  private static Set<Usuario> usuarios;

  public Usuario(int id, String tipo, String nome){
    this.id = id;
    this.tipo = tipo;
    this.nome = nome;
  }

  public static Set<Usuario> all() {
    return usuarios;
  }

  public static Set<Usuario> filterByTipo(String tipo) {
    Set<Usuario> filtrados = new HashSet<>();
    for (Usuario usuario : usuarios)
      if (usuario.tipo.equals(tipo))
        filtrados.add(usuario);

    return filtrados;
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

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

}
