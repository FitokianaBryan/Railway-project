package com.example.datasyncv1.models;

import java.sql.Date;

public class Enchere extends objectBdd.Mere {

    private int idEnchere;
    private int idUtilisateur;
    private  String description;
    private float prixMinimumVente;

    private int durreEnchere;
    private Date dateheureenchere;

    private int status;

    public Enchere()
    {

    }

    public Enchere(int idUtilisateur, String description, float prixMinimumVente, int durreEnchere) {
        this.idUtilisateur = idUtilisateur;
        this.description = description;
        this.prixMinimumVente = prixMinimumVente;
        this.durreEnchere = durreEnchere;
    }

    public Enchere(int idenchere,int idUtilisateur, String description, float prixMinimumVente, int durreEnchere, Date dateheureenchere ,int status) {
        this(idUtilisateur, description, prixMinimumVente, durreEnchere);
        this.status=status;
        this.idEnchere=idenchere;
        this.dateheureenchere=dateheureenchere;
    }

    public Enchere(int idEnchere,int idUtilisateur, String description, float prixMinimumVente, int durreEnchere , int status) {
        this.idEnchere = idEnchere;
        this.idUtilisateur = idUtilisateur;
        this.description = description;
        this.prixMinimumVente = prixMinimumVente;
        this.durreEnchere = durreEnchere;
        this.status = status;
    }

    public Enchere(float prixminimumvente, int dureenchere,int idUtilisateur) {
        this.prixMinimumVente = prixminimumvente;
        this.durreEnchere = dureenchere;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(int idEnchere) {
        this.idEnchere = idEnchere;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrixMinimumVente() {
        return prixMinimumVente;
    }

    public void setPrixMinimumVente(float prixMinimumVente) {
        this.prixMinimumVente = prixMinimumVente;
    }

    public int getDurreEnchere() {
        return durreEnchere;
    }

    public void setDurreEnchere(int durreEnchere) {
        this.durreEnchere = durreEnchere;
    }

    public Date getDateheureenchere() {
        return dateheureenchere;
    }

    public void setDateheureenchere(Date dateheureenchere) {
        this.dateheureenchere = dateheureenchere;
    }
}
