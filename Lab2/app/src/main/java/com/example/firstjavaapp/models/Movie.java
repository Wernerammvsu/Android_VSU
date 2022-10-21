package com.example.firstjavaapp.models;

import androidx.annotation.NonNull;
import java.util.ArrayList;

public class Movie {
    public int id;
    public ExternalId externalId;
    public String type;
    public String name;
    public String alternativeName;
    public String description;
    public String slogan;
    public int year;
    public Poster poster;
    public Backdrop backdrop;
    public Rating rating;
    public Votes votes;
    public Videos videos;
    public Budget budget;
    public Fees fees;
    public Distributors distributors;
    public Premiere premiere;
    public Images images;
    public String status;
    public int movieLength;
    public ArrayList<ProductionCompany> productionCompanies;
    public ArrayList<SpokenLanguage> spokenLanguages;
    public ArrayList<Fact> facts;
    public ArrayList<Genre> genres;
    public ArrayList<Country> countries;
    public ArrayList<Object> seasonsInfo;
    public ArrayList<Person> persons;
    public ArrayList<Object> lists;

    @NonNull
    @Override
    public String toString(){
        return this.name + " " + this.year;
    }
}
