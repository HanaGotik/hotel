package net.source.hotelku.hotelku.networks;

import net.source.hotelku.hotelku.responses.BaseResponse;
import net.source.hotelku.hotelku.responses.OrderResponse;
import net.source.hotelku.hotelku.responses.OrderWResponse;
import net.source.hotelku.hotelku.responses.ProductResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by arcomp on 1/9/2018.
 */

public interface ApiService {

    @GET("/api/product")
    Call<BaseResponse<ProductResponse>> product();

    @GET("/api/paketMedium")
    Call<BaseResponse<ProductResponse>> paketMedium();

    @GET("/api/paketIstimewa")
    Call<BaseResponse<ProductResponse>> paketIstimewa();


    @POST("/api/orderw")
    @FormUrlEncoded
    Call<BaseResponse<OrderWResponse>> orderW(
            @Field("no_ktp") String no,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("telepon") String telepon,
            @Field("type") String type,
            @Field("check_in") String check_in,
            @Field("check_out") String check_out,
            @Field("jumlah") int jumlah,
            @Field("product_id") String productId);
}
