package com.udemy.c1.service.impl;

import com.udemy.c1.component.RequestTimeInterceptor;
import com.udemy.c1.model.Person;
import com.udemy.c1.service.ExampleService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService{
    private static final Log LOG = LogFactory.getLog(ExampleService.class);
    @Override
    public List<Person> getListPeople(){
        //listas
        List<Person> people = new ArrayList<>();
        people.add(new Person("Luis", 20, "quimico"));
        people.add(new Person("leonar", 21, "fisico"));
        people.add(new Person("Donathelo", 22, "Pintor"));
        people.add(new Person("Atena", 23, "Guerrera"));
        people.add(new Person("Naruto", 24, "Hokage"));
        people.add(new Person("Kakashi", 25, "Anbu"));
        people.add(new Person("Irika", 26, "Sensei"));
        LOG.info("hellow from service");
        return people;

        }
    }

