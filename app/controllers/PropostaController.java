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

    public Result indexAguardando() {

        Set<Proposta> propostas = Proposta.find.query().where().ilike("status", Proposta.STATUS_AGUARDANDO)
                .findSet();

        return ok(views.html.pages.propostas.render(propostas));
    }

    public Result indexAceitas() {

        Set<Proposta> propostas = Proposta.find.query().where().ilike("status", Proposta.STATUS_ACEITA)
                .findSet();

        return ok(views.html.pages.propostas.render(propostas));
    }

    public Result indexRecusadas() {

        Set<Proposta> propostas = Proposta.find.query().where().ilike("status", Proposta.STATUS_RECUSADA)
                .findSet();

        return ok(views.html.pages.propostas.render(propostas));
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

    public Result realizar(Integer id) {
        Anuncio anuncio = Anuncio.find.byId(id);
        assert anuncio != null;
        Form<Proposta> propostaForm = formFactory.form(Proposta.class).bindFromRequest();

        Proposta p = new Proposta();
        p.descricao = propostaForm.get().descricao;
        p.usuario_id = anuncio.usuario_id;
        p.anuncio = anuncio;
        p.data = new Date(System.currentTimeMillis());

        p.save();

        return redirect(routes.AnuncioController.index());
    }

   /*
    * @method: ver
    * @param: int anuncio_id, int proposta_id
    * @result: Mostra a view com as informações de uma proposta específica para um anúncio.
    * @http: GET
   */

    public Result ver(int proposta_id) {
        Proposta p = Proposta.find.byId(proposta_id);
        return ok(views.html.pages.proposta.render(p));
    }

   /*
    * @method: responderProposta
    * @param: int anuncio_id, int proposta_id
    * @result: Função para pegar as informações do POST para responder uma proposta.
    * @http: POST
   */

    public Result aceitarProposta(int proposta_id) {
        Proposta atual = Proposta.find.byId(proposta_id);
        assert atual != null;
        atual.aceitar();
        atual.save();
        return redirect(routes.PropostaController.indexAceitas());
    }

    public Result recusarProposta(int proposta_id) {
        Proposta atual = Proposta.find.byId(proposta_id);
        assert atual != null;
        atual.recusar();
        atual.save();
        return redirect(routes.PropostaController.indexAguardando());
    }
}
