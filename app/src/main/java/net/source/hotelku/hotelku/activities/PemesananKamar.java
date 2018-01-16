package net.source.hotelku.hotelku.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.source.hotelku.hotelku.AppsCore;
import net.source.hotelku.hotelku.MainActivity;
import net.source.hotelku.hotelku.R;
import net.source.hotelku.hotelku.models.Product;
import net.source.hotelku.hotelku.networks.RetrofitApi;
import net.source.hotelku.hotelku.responses.BaseResponse;
import net.source.hotelku.hotelku.responses.OrderWResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PemesananKamar extends AppCompatActivity {

    @BindView(R.id.no_ktp)
    EditText NoKTP;

    @BindView(R.id.nama)
    EditText Nama;

    @BindView(R.id.et_alamat)
    EditText Alamat;

    @BindView(R.id.no_telp)
    EditText Telp;

    @BindView(R.id.type)
    TextView Type;

    @BindView(R.id.check_in)
    TextView Check_in;

    @BindView(R.id.check_out)
    TextView Check_out;

    @BindView(R.id.jumlah)
    EditText Jumlah;

    Product product;

    DecimalFormat myFormatter;

    int tahun;
    int bulan;
    int hari;

    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan_kamar);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        product = b.getParcelable("product");

        final Calendar cal = Calendar.getInstance();
        tahun = cal.get(Calendar.YEAR);
        bulan = cal.get(Calendar.MONTH);
        hari = cal.get(Calendar.DAY_OF_MONTH);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, dpickerlistener, tahun, bulan, hari);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerlistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            tahun = year;
            bulan = month + 1;
            hari = day;

            Check_in.setText(tahun + "/" + bulan + "/" + hari);
            Check_out.setText(tahun + "/" + bulan + "/" + hari);
        }
    };

    @OnClick(R.id.btnPesan)
    public void submit() {
        String In = tahun + "-" + bulan + "-" + hari;
        String Out = tahun + "-" + bulan + "-" + hari;

        Call<BaseResponse<OrderWResponse>> call;
        call = RetrofitApi.getInstance().getApiService("").orderW(NoKTP.getText().toString(), Nama.getText().toString(), Telp.getText().toString(),
                Alamat.getText().toString(), Type.getText().toString(),In, Out ,(product.getHarga()),Jumlah.getText().toString());
        call.enqueue(new Callback<BaseResponse<OrderWResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<OrderWResponse>> call, Response<BaseResponse<OrderWResponse>> response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(PemesananKamar.this, MainActivity.class));
                    Toast.makeText(PemesananKamar.this, "berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(PemesananKamar.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {

                    } catch (IOException e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<OrderWResponse>> call, Throwable t) {
                Toast.makeText(PemesananKamar.this, AppsCore.ERROR_NETWORK, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @OnClick(R.id.ib_tgl)
    public void tgl(){showDialog(DIALOG_ID);}
}