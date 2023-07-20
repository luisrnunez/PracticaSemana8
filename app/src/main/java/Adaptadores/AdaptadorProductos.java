package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapprecyclerview.MainActivity;
import com.example.myapprecyclerview.MainActivity2;
import com.example.myapprecyclerview.R;

import org.json.JSONArray;

import java.util.List;

import Modelos.Products;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.UsuarioViewHolder>{

    private MainActivity.OnProductClickListener productClickListener;

    public void setOnProductClickListener(MainActivity.OnProductClickListener listener) {
        this.productClickListener = listener;
    }
    private Context Ctx;
    private List<Products> lstProducts;

    public AdaptadorProductos(Context mCtx, List<Products> Products) {

        this.lstProducts = Products;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.layitemview, null);
        return new UsuarioViewHolder(view);
    }

    // adapta la data con la vista
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Products product = lstProducts.get(position);
        holder.textViewCategoria.setText(product.getCategory());
        holder.textViewTitulo.setText(product.getTitle());
        holder.textViewPrecio.setText(product.getPrice());
        Glide.with(Ctx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productClickListener != null) {
                    productClickListener.onProductClick(product);
                }
            }
        });

    }

    @Override
    public int getItemCount() {return lstProducts.size(); }




    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCategoria, textViewTitulo, textViewPrecio;
        ImageView imageView;
        public UsuarioViewHolder(View itemView) {
            super(itemView);
            textViewCategoria= itemView.findViewById(R.id.txtCate);
            textViewTitulo = itemView.findViewById(R.id.txtTitulo);
            textViewPrecio = itemView.findViewById(R.id.txtMail);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
