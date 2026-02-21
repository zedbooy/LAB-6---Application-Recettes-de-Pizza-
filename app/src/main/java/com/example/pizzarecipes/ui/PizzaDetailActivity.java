package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit pizza = ProduitService.getInstance().findById(id);

        ImageView image = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView meta = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView description = findViewById(R.id.desc);
        TextView steps = findViewById(R.id.steps);

        if (pizza != null) {
            image.setImageResource(pizza.getImageRes());
            title.setText(pizza.getNom());
            meta.setText(pizza.getDuree() + " • " + pizza.formatPrice());
            ingredients.setText(pizza.getIngredients());
            description.setText(pizza.getDescription());
            steps.setText(pizza.getEtapes());
        } else {
            title.setText("Pizza introuvable !");
        }
    }
}