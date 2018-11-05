package com.clientui.proxies;

import com.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Classe permettant d'appeler les fonctions du microservice-produits
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {

    /**
     * fonction listeProduits dans controller de microservice-produits
     * @return
     */
    @GetMapping(value = "microservice-produits/Produits")
    List<ProductBean> listeDesProduits();

    /**
     * fonction recupererUnProduit dans controller de microservice-produits
     * @param id
     * @return
     */
    @GetMapping(value = "microservice-produits/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}