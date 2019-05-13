package controllers;

import play.mvc.*;
import javax.inject.Inject;
import java.util.*;
import models.Proposta;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PropostaController extends Controller {

   /*
    * @method: index
    * @param: none
    * @result: Mostra a view com todos os dados do anúncio.
    * @http: GET
   */

    public Result indexAguardando() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_AGUARDANDO);

        return ok(views.html.pages.propostas.render(propostas));
    }

    public Result indexAceitas() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_ACEITA);

        return ok(views.html.pages.propostas.render(propostas));
    }

    public Result indexRecusadas() {

        Set<Proposta> propostas = Proposta.filterByStatus(Proposta.STATUS_RECUSADA);

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

    public Result realizar(int id) {
        return ok("Handling HTTP POST to send a proposta.");
    }

   /*
    * @method: ver
    * @param: int anuncio_id, int proposta_id
    * @result: Mostra a view com as informações de uma proposta específica para um anúncio.
    * @http: GET
   */

    public Result ver(int proposta_id) {
        Proposta p = Proposta.findById(proposta_id);
        return ok(views.html.pages.proposta.render(p));
    }

   /*
    * @method: responderProposta
    * @param: int anuncio_id, int proposta_id
    * @result: Função para pegar as informações do POST para responder uma proposta.
    * @http: POST
   */

    public Result aceitarProposta(int proposta_id) {
        Proposta atual = Proposta.findById(proposta_id);
        assert atual != null;
        atual.aceitar();
        return redirect(routes.PropostaController.indexAguardando());
    }

    public Result recusarProposta(int proposta_id) {
        Proposta atual = Proposta.findById(proposta_id);
        assert atual != null;
        atual.recusar();
        return redirect(routes.PropostaController.indexAguardando());
    }
}
