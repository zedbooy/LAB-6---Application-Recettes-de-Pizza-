package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private final Context context;
    private final List<Produit> pizzas;

    public PizzaAdapter(Context context, List<Produit> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView meta;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.row_pizza, parent, false);

            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.imgPizza);
            holder.name = convertView.findViewById(R.id.tvNom);
            holder.meta = convertView.findViewById(R.id.tvMeta);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Produit pizza = pizzas.get(position);

        holder.image.setImageResource(pizza.getImageRes());
        holder.name.setText(pizza.getNom());
        holder.meta.setText(pizza.getDuree() + " • " + pizza.formatPrice());

        return convertView;
    }
}