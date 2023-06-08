package com.example.demo;

public class pizza {
    private String nom;
    private int id;
    private float prix;
    private int nbIngredients;

    public pizza(String nom, float prix, int nbIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbIngredients() {
        return nbIngredients;
    }

    public void setNbIngredients(int nbIngredients) {
        this.nbIngredients = nbIngredients;
    }
}
