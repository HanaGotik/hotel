package net.source.hotelku.hotelku;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.hotelku.hotelku.activities.MapsActivity;

public class About extends Fragment implements View.OnClickListener {
    ImageView maps;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);
        textView = view.findViewById(R.id.konten);
        maps = view.findViewById(R.id.mapView);
        maps.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == maps){
            startActivity(new Intent(getActivity(),MapsActivity.class));
        }

    }
}
