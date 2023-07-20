package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapprecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorImagen extends RecyclerView.Adapter<AdaptadorImagen.ImageViewHolder> {


    private Context context;
    private List<String> imagesUrls;

    public AdaptadorImagen(Context context, List<String> imagesUrls) {
        this.context = context;
        this.imagesUrls = imagesUrls;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemimagen, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        String imageUrl = imagesUrls.get(position);

        // Usando Picasso para cargar la imagen desde la URL y mostrarla en el ImageView
        Picasso.get()
                .load(imageUrl)
                //.placeholder(R.drawable.placeholdxer_image) // Imagen de carga mientras se carga la imagen real
                //.error(R.drawable.error_image) // Imagen de error si no se puede cargar la imagen real
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesUrls.size();
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
        notifyDataSetChanged();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
