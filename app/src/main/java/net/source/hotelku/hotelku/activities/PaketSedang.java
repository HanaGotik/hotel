package net.source.hotelku.hotelku.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import net.source.hotelku.hotelku.AppsCore;
import net.source.hotelku.hotelku.R;
import net.source.hotelku.hotelku.adapters.ProductAdapter;
import net.source.hotelku.hotelku.adapters.RecyclerViewAdapter;
import net.source.hotelku.hotelku.networks.RetrofitApi;
import net.source.hotelku.hotelku.responses.BaseResponse;
import net.source.hotelku.hotelku.responses.ProductResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaketSedang extends AppCompatActivity {
    @BindView(R.id.txtCari)
    EditText search;

    @BindView(R.id.rc_product)
    RecyclerView recyclerView;

    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, new ArrayList<net.source.hotelku.hotelku.models.Product>(0));
        recyclerView.setAdapter(productAdapter);

        loadProduct();
    }

    @OnTextChanged(R.id.txtCari)
    void search(){
        Log.d("search",search.getText().toString());
        productAdapter.search(search.getText().toString());
    }

    public void loadProduct() {
        Call<BaseResponse<ProductResponse>> call;
        call = RetrofitApi.getInstance().getApiService("").paketMedium();
        call.enqueue(new Callback<BaseResponse<ProductResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<ProductResponse>> call, Response<BaseResponse<ProductResponse>> response) {
                if(response.isSuccessful()) {
                    List<net.source.hotelku.hotelku.models.Product> products = response.body().getData().getProduct();
                    productAdapter.updateProducts(products);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ProductResponse>> call, Throwable t) {
                Toast.makeText(PaketSedang.this, AppsCore.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
