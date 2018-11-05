package com.clientui.proxies;

import com.clientui.beans.CommandBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * classe permettant d'appeler le microservice commandes
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-commandes")
public interface MicroserviceCommandeProxy {

    /**
     * fonction ajouterCommande dans le controller de microservice-commandes
     * @param commandBean
     * @return
     */
    @PostMapping(value="/microservice-commandes/commandes")
    CommandBean addCommand(@RequestBody CommandBean commandBean);


}
