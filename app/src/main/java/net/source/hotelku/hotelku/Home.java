package net.source.hotelku.hotelku;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.source.hotelku.hotelku.adapters.Data;
import net.source.hotelku.hotelku.adapters.RecyclerViewAdapter;
import net.source.hotelku.hotelku.adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    LinearLayout SliderDots;
    private int dotcounts;
    private ImageView[] dots;
    private Timer timer;
    CardView biasa, sedang, istimewa;
    TextView textView;

    RecyclerView recyclerView;
    List<Data> data_list = new ArrayList<Data>();
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    GridLayoutManager gridLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rc_home);
        recyclerView.setHasFixedSize(true);
           recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapter(getActivity(), data_list);
        recyclerView.setAdapter(adapter);

        viewPager = view.findViewById(R.id.viewPagerHome);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        SliderDots = view.findViewById(R.id.Dots);
        dotcounts = viewPagerAdapter.getCount();

        dots = new ImageView[dotcounts];

        for (int i = 0; i < dotcounts; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_enable));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_unable));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_unable));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_enable));
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        iniData();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTasks(), 1000, 2000);
        return view;

    }

    public  class  TimerTasks extends  TimerTask{

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }


            @Override
            public void onPause() {
                super.onPause();
                timer.cancel();
                timer.purge();
            }

            private void iniData() {
                data_list.add(new Data("Paket 1" + "\n", R.drawable.biasa));
                data_list.add(new Data("Paket 2" + "\n", R.drawable.sedang));
                data_list.add(new Data("Paket 3" + "\n", R.drawable.istimewa));
            }

            @Override
            public void onClick(View view) {

            }
        }
