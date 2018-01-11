package com.example.amirz.appcinema;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by amirz on 1/10/2018.
 */

public class MovieItem {
    public static String name;
    private  String imageUrl;
    public MovieItem(String name, String imageUrl){
        this.name= name;
        this.imageUrl =imageUrl;
    }
    public String getHead() {
        return name;
    }
    public  String getImageUrl(){
        return  imageUrl;
    }
}
