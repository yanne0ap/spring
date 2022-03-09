package com.udemy.c1.model;

public class CourseModel {
    private String name;
    private String description;
    private int hours;
    private int price;
    private int id;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public int getHours(){
        return hours;
    }
    public void setHours(int hours){
        this.hours = hours;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public CourseModel(){}

    public CourseModel(int id, String name, String description, int hours, int price) {
        super();
        id          = id;
        name        = name;
        description = description;
        hours       = hours;
        price       = price;
    }

}
