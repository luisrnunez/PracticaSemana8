package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Adaptadores.AdaptadorProductos;

public class Products {

    private String category;
    private String title;
    private String price;
    private String image;

    private List<String> imagesUrls;

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public Products(JSONObject  a)  throws JSONException  {
        category = a.getString("category").toString();
        title = a.getString("title").toString() ;
        price = a.getString("price").toString() ;
        image = a.getString("thumbnail").toString() ;
        imagesUrls = Collections.singletonList(a.getString("images").toString());
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Products(String image, String title, String price, String category) {
        this.category = category;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public static ArrayList<Products> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Products> Product = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            Product.add(new Products(datos.getJSONObject(i)));
        }
        return Product;

    }
}
