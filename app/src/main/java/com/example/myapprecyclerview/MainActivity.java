package com.example.myapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;


import com.example.myapprecyclerview.WebService.Asynchtask;


import com.example.myapprecyclerview.WebService.WebService;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adaptadores.AdaptadorImagen;
import Adaptadores.AdaptadorProductos;
import Modelos.Products;


public class MainActivity extends AppCompatActivity  implements Asynchtask  {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://dummyjson.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }


    @Override
    public void onProductClick(Products product) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("product", (CharSequence) product);
        startActivity(intent);
    }

    public interface OnProductClickListener {
        void onProductClick(Products product);
    }


    @Override
    public void processFinish(String result) throws JSONException {

    try {
        ArrayList<Products> lstProducts = new ArrayList<Products>();
        JSONObject jsonObject = new JSONObject(result);
        JSONArray productsArray = jsonObject.getJSONArray("products");
        lstProducts = Products.JsonObjectsBuild(productsArray);



        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                resId);
        recyclerView.setLayoutAnimation(animation);


        AdaptadorProductos adaptadorProductos = new AdaptadorProductos(this, lstProducts);
        recyclerView.setAdapter(adaptadorProductos);


    }catch (JSONException e)
    {
        //fakestoreapi.com/products
        Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
    }
    }
}