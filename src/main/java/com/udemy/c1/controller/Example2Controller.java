package com.udemy.c1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    private static final String EXAMPLE2_VIEW = "example2";

    //localhost:8080/example2/request1?nm=JON&eg=22
    //localhost:8080/example2/request1?nm=MYKE&eg=23
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm", required = false) String name, @RequestParam(name="eg", required = false) String age){
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_modal", name);
        mav.addObject("eg", age);
        return mav;
    }

    //localhost:8080/example2/request1/JON/22
    @GetMapping("/request2/{nm}/{eg}")
    public ModelAndView request2(@PathVariable(value = "nm", required = false) String name, @PathVariable(value = "eg",required = false) String ege){
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_modal", name);
        mav.addObject("eg", ege);
        return mav;
    }
}
