package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * classe permettant d'appeler le microservice commandes
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expeditions")
public interface MicroserviceExpeditionsProxy {

    @PostMapping("microservice-expeditions/expeditions")
    ResponseEntity<ExpeditionBean> addExpediton(@Valid @RequestBody ExpeditionBean expeditionBean);

    @GetMapping("microservice-expeditions/expeditions/{id}")
    ExpeditionBean getExpedition(@PathVariable("id") int id);

    @PutMapping("microservice-expeditions/expeditions/{id}")
    void updateExpedition(@PathVariable("id") int id);

}
