package com.example.firstjavaapp.models;

public class Person {
    public int id;
    public String name;
    public String enName;
    public String photo;
    public String enProfession;
    public String description;

    @Override
    public String toString(){
        return this.name + " " + this.enName + " " +this.description;
    }
}
