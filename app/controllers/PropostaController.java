package controllers;

import models.Anuncio;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import javax.inject.Inject;
import java.util.*;
import models.Proposta;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PropostaController extends Controller {

    @Inject
    FormFactory formFactory;

   /*
    * @method: index
    * @param: none
    * @result: Mostra a view com todos os dados do anúncio.
    * @http: GET
   */
   @Security.Authenticated(Secured.class)
    public Result indexAguardando() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_AGUARDANDO);

        return ok(views.html.pages.propostas.render("Pagina", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), propostas));
    }
    @Security.Authenticated(Secured.class)
    public Result indexAceitas() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_ACEITA);

        return ok(views.html.pages.propostas.render("Pagina", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), propostas));
    }
    @Security.Authenticated(Secured.class)
    public Result indexRecusadas() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_RECUSADA);

        return ok(views.html.pages.propostas.render("Pagina", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), propostas));
    }

   /*
    * @method: acompanhar
    * @param: int id
    * @result: Mostra a view com as informações de uma proposta para um anúncio.
    * @http: GET
   */

    public Result acompanhar(int id) {
        return ok("Handling HTTP GET to show the view of a proposta.");
    }

   /*
    * @method: verPropostas
    * @param: int id
    * @result: Mostra a view com todas as propostas de um anúncio.
    * @http: GET
   */

    public Result verPropostas(int id) {
        return ok("Handling HTTP GET to show the view of a proposta.");
    }

   /*
    * @method: realizar
    * @param: int id
    * @result: Função para pegar as informações do POST para realizar uma proposta
    * @http: POST
   */

    public Result realizar(int id) {
        Anuncio anuncio = Anuncio.findById(id);
        assert anuncio != null;
        Form<Proposta> propostaForm = formFactory.form(Proposta.class).bindFromRequest();


        Proposta p = new Proposta(id + 2, Proposta.STATUS_AGUARDANDO,
                propostaForm.get().getDescricao(), anuncio.usuario_id, anuncio.id);

        anuncio.addProposta(p);
        Proposta.all().add(p);
        return redirect(routes.AnuncioController.index());
    }

   /*
    * @method: ver
    * @param: int anuncio_id, int proposta_id
    * @result: Mostra a view com as informações de uma proposta específica para um anúncio.
    * @http: GET
   */
    @Security.Authenticated(Secured.class)
    public Result ver(int proposta_id) {
        Proposta p = Proposta.findById(proposta_id);
        return ok(views.html.pages.proposta.render("Pagina", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), p));
    }

   /*
    * @method: responderProposta
    * @param: int anuncio_id, int proposta_id
    * @result: Função para pegar as informações do POST para responder uma proposta.
    * @http: POST
   */
    @Security.Authenticated(Secured.class)
    public Result aceitarProposta(int proposta_id) {
        Proposta atual = Proposta.findById(proposta_id);
        assert atual != null;
        atual.aceitar();
        return redirect(routes.PropostaController.indexAceitas());
    }
    @Security.Authenticated(Secured.class)
    public Result recusarProposta(int proposta_id) {
        Proposta atual = Proposta.findById(proposta_id);
        assert atual != null;
        atual.recusar();
        return redirect(routes.PropostaController.indexAguardando());
    }
}
