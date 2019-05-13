package controllers;

import play.mvc.*;
import javax.inject.Inject;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UsuarioController extends Controller {

    public Result index() {
        return ok(views.html.pages.home.render());
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
