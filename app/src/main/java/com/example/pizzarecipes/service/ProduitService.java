package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProduitService implements IDao<Produit> {

    private static ProduitService instance;
    private final List<Produit> produits;

    private ProduitService() {
        produits = new ArrayList<>();
        seedData();
    }

    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    private void seedData() {

        produits.add(new Produit(
                "Barbecue Chicken Pizza",
                35.0,
                R.mipmap.pizza1,
                "35 min",
                "Chicken, BBQ sauce, mozzarella",
                "Délicieuse pizza au poulet barbecue.",
                "1. Cuire le poulet\n2. Ajouter sauce\n3. Cuire au four"
        ));

        produits.add(new Produit(
                "Spinach Pizza",
                25.0,
                R.mipmap.pizza2,
                "25 min",
                "Spinach, alfredo sauce, cheese",
                "Pizza crémeuse aux épinards.",
                "1. Étaler pâte\n2. Ajouter garniture\n3. Cuire"
        ));
    }

    @Override
    public Produit create(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public Produit update(Produit produit) {
        Optional<Produit> existing = produits.stream()
                .filter(p -> p.getId() == produit.getId())
                .findFirst();

        existing.ifPresent(p -> {
            p.setNom(produit.getNom());
            p.setPrix(produit.getPrix());
            p.setImageRes(produit.getImageRes());
            p.setDuree(produit.getDuree());
            p.setIngredients(produit.getIngredients());
            p.setDescription(produit.getDescription());
            p.setEtapes(produit.getEtapes());
        });

        return existing.orElse(null);
    }

    @Override
    public boolean delete(long id) {
        return produits.removeIf(p -> p.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        return produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(produits);
    }

    @Override
    public int count() {
        return produits.size();
    }

    // BONUS 🔥
    public List<Produit> searchByName(String keyword) {
        return produits.stream()
                .filter(p -> p.getNom().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}