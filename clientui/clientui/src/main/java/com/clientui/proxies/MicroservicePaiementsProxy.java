package com.clientui.proxies;

import com.clientui.beans.PaiementBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * classe permettant d'appeler les fonctions de microservice-paiement
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-paiement")
public interface MicroservicePaiementsProxy {
    /**
     * fonction payerUneCommande dans controller de microservice-paiement
     * @param paiementBean
     * @return
     */
    @PostMapping(value="/microservice-paiement/paiement")
ResponseEntity<PaiementBean> payCommand(@RequestBody PaiementBean paiementBean);
}
