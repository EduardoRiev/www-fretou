package controllers;

import models.Anuncio;
import models.Proposta;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import javax.inject.Inject;
import java.util.Set;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AnuncioController extends Controller {

    @Inject
    FormFactory formFactory;

   /*
    * @method: index
    * @param: none
    * @result: Mostra a view com todos os dados do anúncio.
    * @http: GET
   */

    public Result index() {

        Set<Anuncio> anuncios = Anuncio.all();

        return ok(views.html.pages.anuncios.render(anuncios));
    }

   /*
    * @method: show
    * @param: String slug
    * @result: Mostra a view de um anúncio específico.
    * @http: GET
   */

    public Result show(int id) {
        Form propostaForm = formFactory.form(Proposta.class);

        return ok(views.html.pages.anuncio.render(Anuncio.findById(id), propostaForm));
    }

   /*
    * @method: create
    * @param: none
    * @result: Mostra a view para criar um anúncio.
    * @http: GET
   */

    public Result create() {
        return ok("Handlig HTTP GET to show the view to create an anuncio.");
    }

   /*
    * @method: store
    * @param: none
    * @result: Sessão para salvar os dados do anúncio vindo da página de criação.
    * @http: POST
   */

    public Result store() {
        return ok("Handling HTTP POST to store anuncio");
    }

   /*
    * @method: edit
    * @param: int Id
    * @result: Página de editar o anuncio.
    * @http: GET
   */

    public Result edit(int id) {
        return ok("Handling HTTP GET to show the view to edit an anuncio.");
    }

   /*
    * @method: update
    * @param: int Id
    * @result: Função para controlar a requisição de atualização dos dados do anúncio
    * @http: PATCH
   */

    public Result update(int id) {
        return ok("Handling HTTP PATCH to update an anuncio.");
    }

    /*
     * @method: realizar
     * @param: int id
     * @result: Função para enviar a requisição e realizar uma negociação.
     * @http: POST
     */

    public Result realizar(int id) {
        return ok("Handling HTTP POST to realizar proposta a um anuncio");
    }
}
