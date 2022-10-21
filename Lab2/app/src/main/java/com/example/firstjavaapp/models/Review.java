package com.example.firstjavaapp.models;


import java.util.ArrayList;

public class Review {
        public ArrayList<DocReview> docs;
        public int total;
        public int limit;
        public int page;
        public int pages;

        @Override
        public String toString(){
                return String.valueOf(this.docs.get(0).review) + " , всего отзывов: " + this.total;
        }
}
