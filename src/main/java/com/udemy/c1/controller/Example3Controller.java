package com.udemy.c1.controller;

import com.udemy.c1.model.Person;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
    public static final String FORM_VIEW = "form";
    public  static final String RESULT_VIEW = "result";

    /*@GetMapping("/")
    public String redirect(){
        return "redirect:/example3/showform";
    }*/

    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }

    @GetMapping("/showform")
    public String showform(Model model){
        //como imprimir el log de la aplicacion
        LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.debug("DEBUG TRACE");
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        LOGGER.info("METHOD:'addperson' -- PARAMS:'"+ person +"'");
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person);
        LOGGER.info("TEMPLATE: "+ RESULT_VIEW + "-- DATA: "+ person);
        return mav;
    }
}
