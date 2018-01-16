package net.source.hotelku.hotelku.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.source.hotelku.hotelku.R;

/**
 * Created by arcomp on 1/3/2018.
 */

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images ={R.drawable.fasilitas2, R.drawable.fasilitas3, R.drawable.fasilitas4, R.drawable.fasilitas5};

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }


    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_item, null);
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(images[position]);

        ViewPager vp =(ViewPager)container;
        vp.addView(view,0);
        return view;
    }
}
