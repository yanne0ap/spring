package com.udemy.c1.controller;

import com.udemy.c1.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/say")
public class hellowcontroller {

    public static final String Example_View = "hellow";

    @GetMapping("/hello")
    public String hello(){
        return Example_View;
    }



}
