package com.clientui.proxies;

import com.clientui.beans.CommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="zuul-server", url="localhost:9002")
public interface MicroserviceCommandesProxy {
    @PostMapping(value="/microservice-commandes/commandes")
    CommandBean addCommand(@RequestBody  CommandBean commandBean);
}
