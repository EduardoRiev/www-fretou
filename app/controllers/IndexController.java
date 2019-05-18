package controllers;

import play.mvc.*;
import play.data.*;
import java.util.*;
import models.Usuario;
import models.UsuariosDB;
import views.helper.LoginForm;
import javax.inject.Inject;

/**
* This controller contains an action to handle HTTP requests
* to the application's index page.
*/
public class IndexController extends Controller {

  @Inject
  FormFactory formFactory;

  public Result index() {
    return ok(views.html.index.render("Inicio", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  public Result login() {

    Form<LoginForm> formData = formFactory.form(LoginForm.class);

    return ok(views.html.pages.login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  public Result doLogin(){
    Form<LoginForm> formData = formFactory.form(LoginForm.class).bindFromRequest();

    if (formData.hasErrors()) {

        if(formData.error("email") != null)
          flash("error", "Email não encontrado.");
        else if(formData.error("senha") != null)
          flash("error", "Senha incorreta.");

        return badRequest(views.html.pages.login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }else{
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().getEmail());
      return redirect(routes.UsuarioController.index());
    }
  }

  /*************
  Adiciona os usuarios na memória
  ****************/
  public Result setup(){
    UsuariosDB.addUserInfo(1, "a@a.net", "123", "cliente");
    UsuariosDB.addUserInfo(2, "ba@a.net", "123", "cliente");
    UsuariosDB.addUserInfo(3, "xba@a.net", "123", "motorista");
    return redirect(routes.IndexController.debug());
  }

  public Result debug(){
    return ok(views.html.debug.render());
  }

}
