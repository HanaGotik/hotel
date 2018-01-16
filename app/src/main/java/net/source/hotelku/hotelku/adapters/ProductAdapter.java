package net.source.hotelku.hotelku.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import net.source.hotelku.hotelku.AppsCore;
import net.source.hotelku.hotelku.R;
import net.source.hotelku.hotelku.models.Product;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arcomp on 1/9/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<Product> productList;
    private ArrayList<Product> productView;
    private String search;
    private ProductItemListener productListener;
    DecimalFormat myFormatter;

    public ProductAdapter(final Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.productView = new ArrayList<>(0);
        this.search = "";
        this.productListener = new ProductItemListener(){
            @Override
            public void onPostClick(Product product) {
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("product", product);
                i.putExtras(b);
                context.startActivity(i);
            }

        };
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_layout, parent,false);

        ProductAdapter.ViewHolder viewHolder= new ProductAdapter.ViewHolder(view, this.productListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        final Product item = productView.get(position);
        TextView kamar = holder.kamar;
        TextView harga = holder.harga;
        ImageView imgDeskripsi = holder.image;
        Button btnPesan = holder.btnPesan;
        kamar.setText(item.getType());
        harga.setText("Rp "+myFormatter.format(item.getHarga()));
        String url = AppsCore.BASE_IMAGE+item.getImage();

        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder()
                .build());
        Glide.with(context).load(glideUrl). into(imgDeskripsi);

        btnPesan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("product", item);
                b.putInt("tambahan",0);
                i.putExtras(b);

            }
        });
    }

    @Override
    public int getItemCount() {
        return productView.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView image;
        public TextView kamar;
        public TextView harga;
        public Button btnPesan;

        ProductItemListener productItemListener;

        public ViewHolder(View itemView, ProductItemListener productItemListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            kamar = itemView.findViewById(R.id.type_kamar);
            harga = itemView.findViewById(R.id.txtHargaItem);
            btnPesan = itemView.findViewById(R.id.btnPesan);

            this.productItemListener = productItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product item = getItem(getAdapterPosition());
            this.productItemListener.onPostClick(item);

            notifyDataSetChanged();
        }
    }

    private void updateView(){
        this.productView = new ArrayList<>();
        for (int i=0;i<this.productList.size();i++){
            if (this.search.equals("")){
                this.productView.add(this.productList.get(i));
            }else{
                if (this.productList.get(i).getType().toLowerCase().matches("(.*)"+search.toLowerCase()+"(.*)")){
                    this.productView.add(this.productList.get(i));
                }
            }
        }
    }

    public void updateProducts(List<Product> items) {
        productList = items;
        this.updateView();
        notifyDataSetChanged();
    }

    public void search(String search){
        this.search = search;
        this.updateView();
        notifyDataSetChanged();
    }

    private Product getItem(int adapterPosition){
        return productView.get(adapterPosition);
    }

    public interface ProductItemListener{
        void onPostClick(Product id);
    }
}
