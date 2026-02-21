package com.example.pizzarecipes;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzarecipes.ui.SplashActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Redirige vers SplashActivity si jamais lancée directement
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}