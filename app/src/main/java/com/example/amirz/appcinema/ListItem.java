package com.example.amirz.appcinema;

/**
 * Created by amirz on 1/8/2018.
 */

public class ListItem {
    public  String head;
    public  String id;
    private  String imageUrl;

    public ListItem(String head,String imageUrl){
        this.head = head;
        this.imageUrl =imageUrl;
    }

    public ListItem(String head) {
        this.head=head;
    }

    public String getHead() {
        return head;
    }
    public  String getImageUrl(){
        return  imageUrl;
    }

}
