package net.source.hotelku.hotelku.adapters;

/**
 * Created by SONY on 27/12/2017.
 */

public class Data {

    private String judul;
    private int imageID;
    private int harga;

    public Data(String s, int biasa){

    }

    public Data(String judul, int imageID, int harga) {
        this.judul = judul;
        imageID = imageID;
        harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getImageID() { return imageID; }

    public void setImageID(int imageID) {
        imageID = imageID;
    }

    public int getHarga(){ return harga;}

    public void setHarga(int harga){
        this.harga = harga;
    }
}
