package com.udemy.c1.model;

public class Person {
    private String name;
    private String profe;
    private int age;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }


    public String getProf(){
        return profe;
    }
    public void setProf(String Profe){
        this.profe = Profe;
    }
    public Person(String name, int age, String Profe){
        super();
        this.age = age;
        this.name = name;
        this.profe = Profe;
    }

    public Person(){}

}
