package com.example.myapprecyclerview.WebService;


import org.json.JSONException;

import Modelos.Products;

public interface Asynchtask {
    void onProductClick(Products product);

    /**
     * ESta funcion retorna los datos devueltos por el ws
     * @param result
     */
    void processFinish(String result) throws JSONException;

}
