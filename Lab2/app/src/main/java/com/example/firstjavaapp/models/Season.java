package com.example.firstjavaapp.models;

import java.util.ArrayList;

public class Season {
    public ArrayList<DocSeason> docs;
    public int total;
    public int limit;
    public int page;
    public int pages;

    @Override
    public String toString(){
        return String.valueOf(this.docs.get(0).episodes.get(0).name) + " , всего: " + this.total;
    }
}
