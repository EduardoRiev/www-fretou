package models;

import java.util.*;

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
  private String sexo;
  private String dataNascimento;
  private String telefone;
  private String email; 
  private String senha; 
  private Integer numAvaliacoes; 
  private Integer ptsAvaliacoes;  

  private static Set<Usuario> usuarios;

  public Usuario(int id, String tipo, String nome, String sexo, String dataNascimento, String email, String senha,
   Integer numAvaliacoes, Integer ptsAvaliacoes){
    this.id = id;
    this.tipo = tipo;
    this.nome = nome;
    this.sexo = sexo;
    this.dataNascimento = dataNascimento;
    this.email = email;
    this.senha = senha;
    this.numAvaliacoes = numAvaliacoes;
    this.ptsAvaliacoes = ptsAvaliacoes;
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

  public void setSexo(String sexo){
    this.sexo = sexo;
  }

  public String getSexo(String sexo) {
    return this.sexo;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getTelefone(String telefone) {
    return this.telefone;
  }

  public String getDataNascimento(String dataNascimento) {
    return this.dataNascimento;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail(String email) {
    return this.email;
  }
  
  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getSenha(String senha) {
    return this.senha;
  }

  public void setNumAvaliacoes(Integer numAvaliacoes){
    this.numAvaliacoes = numAvaliacoes;
  }

  public Integer getNumAvaliacoes(Integer numAvaliacoes){
    return this.numAvaliacoes;
  }

  private void setPtsAvalicoes(Integer ptsAvaliacoes){
    this.ptsAvaliacoes = ptsAvaliacoes;
  }

  private Integer getPtsAvalicoes(Integer ptsAvaliacoes){
    return this.ptsAvaliacoes;
  }
}
