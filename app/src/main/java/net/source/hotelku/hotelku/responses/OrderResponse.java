package net.source.hotelku.hotelku.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.source.hotelku.hotelku.models.OrderW;

/**
 * Created by arcomp on 1/9/2018.
 */

public class OrderResponse {

    @SerializedName("data")
    @Expose
    public OrderW data;

    public OrderW getData() {
        return data;
    }

    public void setData(OrderW data) {
        this.data = data;
    }

}
