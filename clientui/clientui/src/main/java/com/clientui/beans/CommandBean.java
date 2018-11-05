/**
 *
 */
package com.clientui.beans;

import java.util.Date;

/**
 * Classe correspondant au
 */
public class CommandBean {


    private int id;

    private Integer productId;

    private Date dateCommande;

    private Integer quantite;

    private Boolean commandePayee;

    public CommandBean() {
    }

    /**
     * constructor with all parameters
     *
     * @param id
     * @param productId
     * @param dateCommande
     * @param quantite
     * @param commandePayee
     */
    public CommandBean(int id, Integer productId, Date dateCommande, Integer quantite, Boolean commandePayee) {
        this.id = id;
        this.productId = productId;
        this.dateCommande = dateCommande;
        this.quantite = quantite;
        this.commandePayee = commandePayee;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     *
     * @return
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     *
     * @param dateCommande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     *
     * @return
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     *
     * @param quantite
     */
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    /**
     *
     * @return
     */
    public Boolean getCommandePayee() {
        return commandePayee;
    }

    /**
     *
     * @param commandePayee
     */
    public void setCommandePayee(Boolean commandePayee) {
        this.commandePayee = commandePayee;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", productId=" + productId +
                ", dateCommande=" + dateCommande +
                ", quantite=" + quantite +
                ", commandePayee=" + commandePayee +
                '}';
    }
}
