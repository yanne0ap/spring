package com.udemy.c1.entity;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HOURS")
    private  int hours;
    @Column(name = "PRICE")
    private  int price;

    public Course(){}

    public Course(int id, String name, String description, int hours, int price) {
        super();
        id          = id;
        name        = name;
        description = description;
        hours       = hours;
        price       = price;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

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

    @Override
    public String toString(){
        return "Course [id="+id+",name="+name+",description="+description+",hours="+hours+",price="+price+"]";
    }


}
