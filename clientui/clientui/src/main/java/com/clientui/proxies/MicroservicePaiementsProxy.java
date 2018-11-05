package com.clientui.proxies;

import com.clientui.beans.PaiementBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
//@FeignClient(name="microservice-paiement", url="localhost:9003")
@RibbonClient(name = "microservice-paiement")
public interface MicroservicePaiementsProxy {
@PostMapping(value="/microservice-paiement/paiement")
ResponseEntity<PaiementBean> payCommand(@RequestBody PaiementBean paiementBean);
}
