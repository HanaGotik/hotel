package net.source.hotelku.hotelku.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.source.hotelku.hotelku.R;
import net.source.hotelku.hotelku.activities.Paket;
import net.source.hotelku.hotelku.activities.PaketIstimewa;
import net.source.hotelku.hotelku.activities.PaketSedang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 27/12/2017.
 */
class  MenuHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textView;
    public LinearLayout layout;

    public MenuHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageMenu);
        textView = itemView.findViewById(R.id.namaJudul);
        layout = itemView.findViewById(R.id.layout_item);

    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<MenuHolder> {
    private Context context;
    private List<Data> ListData = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<Data> listData) {
        this.context = context;
        ListData = listData;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_item_menu,parent,false);
        return new MenuHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MenuHolder holder, final int position) {
        holder.imageView.setImageResource(ListData.get(position).getImageID());
        holder.textView.setText(ListData.get(position).getJudul());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    context.startActivity(new Intent(context, Paket.class));
                }
                if (position == 1){
                    context.startActivity(new Intent(context, PaketSedang.class));
                }
                if (position == 2){
                    context.startActivity(new Intent(context, PaketIstimewa.class));
                }


            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0){
                    context.startActivity(new Intent(context, Paket.class));
                }
                if (position == 0){
                    context.startActivity(new Intent(context, PaketSedang.class));
                }
                if (position == 0){
                    context.startActivity(new Intent(context, PaketIstimewa.class));
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return ListData.size();
    }



}
