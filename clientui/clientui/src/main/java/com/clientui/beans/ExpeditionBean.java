package com.clientui.beans;

import org.hibernate.validator.constraints.Range;

public class ExpeditionBean {
    private int id;

    private int idCommande;
    @Range(min=0,max=2)
    private int etat;

    public ExpeditionBean() {
    }

    public ExpeditionBean(int id, int idCommande, int etat) {
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
