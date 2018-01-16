package net.source.hotelku.hotelku.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.DatePicker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arcomp on 1/9/2018.
 */

public class Product implements Parcelable {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("harga")
    @Expose
    public Integer harga;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updatedAt) {
        this.updated = updatedAt;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Integer getHarga(){
        return harga;
    }

    public void setHarga(Integer harga){
        this.harga = harga;
    }

    protected Product(Parcel in) {
        String[] data = new String[8];

        in.readStringArray(data);
        this.image = data[0];
        this.type = data[1];
        this.harga = Integer.parseInt(data[2]);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
       parcel.writeStringArray(new String[]{
               this.image,
               this.type,
               this.harga+ ""
       });
    }
}
