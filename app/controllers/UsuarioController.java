package controllers;

import play.mvc.*;
import javax.inject.Inject;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UsuarioController extends Controller {

    @Security.Authenticated(Secured.class)
    public Result index() {
        return ok(views.html.pages.usuario.inicio.render("Painel de Controle", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    /**
    * Logs out (only for authenticated users) and returns them to the Index page.
    * @return A redirect to the Index page.
    */
    @Security.Authenticated(Secured.class)
    public Result logout() {
      session().clear();
      return redirect(routes.IndexController.index());
    }


   /*
    * @method: avaliar
    * @param: int usuario_id, int anuncio_id
    * @result: Mostra a view com informações do usuário e do anúncio para ser avaliado.
    * @http: GET
   */

    public Result avaliacao(int usuario_id, int anuncio_id) {
        return ok("view de avaliar um usuario e algumas informações do anuncio.");
    }

   /*
    * @method: avaliacao
    * @param: int usuario_id, int anuncio_id
    * @result: Mostra a view com todos os dados do anúncio.
    * @http: POST
   */

    public Result avaliar(int usuario_id, int anuncio_id) {
        return ok("Handling HTTP POST to update avaliacao table.");
    }


}
