package net.source.hotelku.hotelku.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arcomp on 1/9/2018.
 */

public class OrderW {

    @SerializedName("no_ktp")
    @Expose
    public Integer no_ktp;
    @SerializedName("nama")
    @Expose
    public String nama;
    @SerializedName("alamat")
    @Expose
    public String alamat;
    @SerializedName("telepon")
    @Expose
    public int telepon;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("check_in")
    @Expose
    public int check_in;
    @SerializedName("check_out")
    @Expose
    public int check_out;
    @SerializedName("jumlah")
    @Expose
    public Integer jumlah;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("image")
    @Expose
    public String image;

    public Integer getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(Integer no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getTelepon() {
        return telepon;
    }

    public void setTelepon(Integer telepon) {
        this.telepon = telepon;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public int getCheck_in() {
        return check_in;
    }

    public void setCheck_in(int check_in) {
        this.check_in = check_in;
    }

    public int getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Integer check_out) {
        this.check_out = check_out;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}