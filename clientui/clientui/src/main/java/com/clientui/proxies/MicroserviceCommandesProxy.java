package com.clientui.proxies;

import com.clientui.beans.CommandBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * classe permettant d'appeler le microservice commandes
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-commandes")
public interface MicroserviceCommandesProxy {

    /**
     * fonction ajouterCommande dans le controller de microservice-commandes
     * @param commandBean
     * @return
     */
    @PostMapping(value="/microservice-commandes/commandes")
    CommandBean addCommand(@RequestBody CommandBean commandBean);

    @GetMapping(value = "/microservice-commandes/commandes/{id}")
    CommandBean getCommand(@PathVariable("id") int id);

    @PutMapping(value="/microservice-commandes/commandes/{commandeId}")
    void updateCommand(@RequestBody CommandBean commandBean, @PathVariable("commandeId") int commandeId);


}
