package com.udemy.c1.controller;

import com.udemy.c1.component.ExampleComponent;
import com.udemy.c1.model.Person;
import com.udemy.c1.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    @GetMapping("/hello")
    public String hello(){
        return "login";
    }

    //Enviar datos forma 1
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mv = new ModelAndView(Example_View);
        mv.addObject("name", "ALex");
        mv.addObject("titulo", "prueba yanne");
        return mv;

    }

    //Enviar datos forma 2
    @GetMapping("/exampleMV")
    public String exampleS(Model model, Model titulo){
        model.addAttribute("name", "alex 2");
        titulo.addAttribute("titulo", "pruebas yanne 2");
        return Example_View;
    }

    //Enviar datos forma super
    @GetMapping("/example3a")
    public ModelAndView example3a(){
        ModelAndView mv = new ModelAndView(Example_View);
        mv.addObject("people", exampleService.getListPeople());
        return mv;

    }

    //Enviar datos forma super 2
    @GetMapping("/example3b")
    public String example3b(Model model){
        exampleComponent.sayHello();
        model.addAttribute("people", exampleService.getListPeople());
        return Example_View;
    }



}
