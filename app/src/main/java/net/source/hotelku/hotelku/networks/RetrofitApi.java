package net.source.hotelku.hotelku.networks;

import android.media.session.PlaybackState;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.source.hotelku.hotelku.AppsCore;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arcomp on 1/9/2018.
 */

public class RetrofitApi {
    private ApiService mApiService;
    private static RetrofitApi instance = null;
    private Retrofit retrofit;
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
    private String token;

    public  static RetrofitApi getInstance(){
        instance = new RetrofitApi();

        return  instance;
    }

    private RetrofitApi(){
        retrofit = new Retrofit.Builder().baseUrl(AppsCore.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttp().build())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService(String token){
        this.token = token;
        return mApiService;
    }

    public ApiService getApiService(){
        return mApiService;
    }

    private OkHttpClient.Builder getOkHttp() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Network", message);
            }
        });
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(request);

            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);
        return httpClient;
    }
}
