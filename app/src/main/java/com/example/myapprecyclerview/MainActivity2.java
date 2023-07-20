package com.example.myapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorImagen;
import Adaptadores.AdaptadorProductos;
import Modelos.Products;

public class MainActivity2 extends AppCompatActivity    {



    private RecyclerView imageRecyclerView;
    private AdaptadorImagen imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el RecyclerView y el adaptador de imágenes
        imageRecyclerView = findViewById(R.id.recyclerView);
        imageRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columnas en la cuadrícula
        imageAdapter = new AdaptadorImagen(this, new ArrayList<>());
        imageRecyclerView.setAdapter(imageAdapter);
    }

    // Resto del código de la actividad o fragmento
}
