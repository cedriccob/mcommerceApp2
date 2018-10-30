package com.clientui.proxies;

import com.clientui.beans.PaiementBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="zuul-server",url = "localhost:9003")
public interface MicroservicePaiementsProxy {
@PostMapping(value="/microservice-paiement/paiement")
ResponseEntity<PaiementBean> payCommand(@RequestBody PaiementBean paiementBean);
}
