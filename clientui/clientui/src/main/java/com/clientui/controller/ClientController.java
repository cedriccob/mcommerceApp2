/**
 *
 */
package com.clientui.controller;

import com.clientui.beans.CommandBean;
import com.clientui.beans.PaiementBean;
import com.clientui.beans.ProductBean;
import com.clientui.proxies.MicroserviceCommandesProxy;
import com.clientui.proxies.MicroservicePaiementsProxy;
import com.clientui.proxies.MicroserviceProduitsProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Controller du client
 */
@Controller
public class ClientController {

    Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MicroserviceProduitsProxy microserviceProduitsProxy;

    @Autowired
    private MicroserviceCommandesProxy microserviceCommandeProxy;

    @Autowired
    private MicroservicePaiementsProxy microservicePaiementsProxy;

    /**
     * fonction appelée au démarrage de l'application
     * @param model
     * @return template accueil
     */
    @RequestMapping("/")
    public String accueil(Model model){
        List<ProductBean> produits = microserviceProduitsProxy.listeDesProduits();
        model.addAttribute("produits",produits);
        log.info("Envoi de requête vers MicroserviceProduits");
        return "accueil";
    }

    /**
     * fonction appelée lors du clic sur un produit
     * @param model
     * @param id
     * @return template product
     */
    @RequestMapping("details-produit/{id}")
    public String productDetail(Model model, @PathVariable int id){
        ProductBean produit = microserviceProduitsProxy.recupererUnProduit(id);
        model.addAttribute("produit",produit);
        return "product";
    }

    /**
     * fonction appelée lors du clic sur le bouton commander
     * @param model
     * @param productId
     * @param productPrix
     * @return template paiement
     */
    @RequestMapping(value = "/commander-produit/{productId}/{productPrix}")
    public String commandProduct(Model model, @PathVariable int productId, @PathVariable double productPrix){
        CommandBean commandBean = new CommandBean();

        commandBean.setProductId(productId);
        commandBean.setQuantite(1);
        commandBean.setDateCommande(new Date());
        CommandBean commandAdded = microserviceCommandeProxy.addCommand(commandBean);

        model.addAttribute("commandAdded",commandAdded);
        model.addAttribute("prix",productPrix);

        return "paiement";
    }

    /**
     * fonction appelée lors du clic sur payer
     * @param model
     * @param idCommand
     * @param montantCommand
     * @return template confirmation
     */
    @RequestMapping(value = "payer-command/{idCommand}/{montantCommand}")
    public String payCommand(Model model, @PathVariable int idCommand, @PathVariable double montantCommand){

        PaiementBean paiementBean = new PaiementBean();
        paiementBean.setIdCommande(idCommand);
        paiementBean.setMontant(montantCommand);
        paiementBean.setNumeroCarte(numCarte());

        ResponseEntity<PaiementBean> paiement = microservicePaiementsProxy.payCommand(paiementBean);
        CommandBean commandBean = microserviceCommandeProxy.getCommand(idCommand);

        Boolean paiementAccepte = false;

        if(paiement.getStatusCode()== HttpStatus.CREATED) {
            paiementAccepte = true;

            commandBean.setCommandePayee(true);


        }
        else
            commandBean.setCommandePayee(false);

        microserviceCommandeProxy.updateCommand(commandBean,idCommand);

        model.addAttribute("paiementOk",paiementAccepte);

        return "confirmation";
    }

    /**
     * fonction random pour simuler un numéro de carte
     * @return un nombre aléatoire
     */
    private Long numCarte() {
        return ThreadLocalRandom.current().nextLong(1000000000000000L,9000000000000000L);
    }


}
