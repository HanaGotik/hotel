package net.source.hotelku.hotelku.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.source.hotelku.hotelku.models.Product;

import java.util.List;

/**
 * Created by arcomp on 1/9/2018.
 */

public class ProductResponse {

    @SerializedName("product")
    @Expose
    public List<Product> product = null;

    public List<Product> getProduct(){
        return product;
    }

    public void  setProduct(List<Product> product){
        this.product = product;
    }
}
