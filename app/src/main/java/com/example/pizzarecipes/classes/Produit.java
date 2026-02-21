package com.example.pizzarecipes.classes;

import java.text.DecimalFormat;

public class Produit {

    private static long counter = 0;

    private final long id;
    private String nom;
    private double prix;
    private int imageRes;
    private String duree;
    private String ingredients;
    private String description;
    private String etapes;

    public Produit(String nom, double prix, int imageRes,
                   String duree, String ingredients,
                   String description, String etapes) {

        this.id = ++counter;
        this.nom = nom;
        this.prix = prix;
        this.imageRes = imageRes;
        this.duree = duree;
        this.ingredients = ingredients;
        this.description = description;
        this.etapes = etapes;
    }

    public long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }

    public String getDuree() { return duree; }
    public void setDuree(String duree) { this.duree = duree; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEtapes() { return etapes; }
    public void setEtapes(String etapes) { this.etapes = etapes; }

    public String formatPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(prix) + " €";
    }

    @Override
    public String toString() {
        return nom + " (" + formatPrice() + ")";
    }
}