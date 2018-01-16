package net.source.hotelku.hotelku;

import android.app.Application;

/**
 * Created by arcomp on 1/2/2018.
 */

public  class AppsCore extends Application {
    public static final String BASE_URL = "http://sabunwings.000webhostapp.com/";
    public static final String BASE_IMAGE = "http://app.digphotoworks.com/images/";
    public static final String ERROR = "An error has occurred, ";
    public static final String TOKEN_EXPIRED = "Sesi login anda telah habis, silahkan melakukan login ulang !";
    public static final String TAG_TOKEN_EXPIRED = "token_expired";

    public static int ERROR_NETWORK;
}
