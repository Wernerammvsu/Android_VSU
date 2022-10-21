package com.example.firstjavaapp.models;

import java.util.ArrayList;

public class Image {

    public ArrayList<DocImage> docs;
    public int total;
    public int limit;
    public int page;
    public int pages;

    @Override
    public String toString(){
        return this.docs.get(0).previewUrl + " , высота: " + this.docs.get(0).height;
    }
}
