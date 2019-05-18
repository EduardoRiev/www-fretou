package views.helper;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UsuariosDB;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Validate;
import play.data.validation.Constraints.Validatable;

@Validate
public class LoginForm implements Validatable<List<ValidationError>> {

  @Constraints.Required protected String email = "";
  @Constraints.Required protected String senha = "";

  public LoginForm(){

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
  /**
    Validacao de erros do formulario
    usado no bindFromRequest();
    @return Null se for válido, ou uma List[ValidationError] se tiver problema.
  */
  @Override
  public List<ValidationError> validate() {

    final List<ValidationError> errors = new ArrayList<>();
    if(!UsuariosDB.isUser(email)){
      errors.add(new ValidationError("email", "Email não cadastrado."));
    }else{
       if (!UsuariosDB.isValid(email, senha)) {
        errors.add(new ValidationError("senha", "Senha incorreta"));
      }
    }

    return (errors.size() > 0) ? errors : null;
  }
}
