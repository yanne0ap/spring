package com.udemy.c1.controller;

import com.udemy.c1.entity.Course;
import com.udemy.c1.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSE_VIEW = "courses";

    private static final Log LOG = LogFactory.getLog(CourseController.class);


    @Autowired
    @Qualifier("courseServiceImp")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView ListAllCourses() {
        LOG.info("Call: " + "ListAllCourses()");
        ModelAndView mva = new ModelAndView(COURSE_VIEW);
        mva.addObject("courses", new Course());
        mva.addObject("Course", courseService.ListAllCourses());
        return mva;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOG.info("Call: " + "addCourse()"+" -- Param: "+ course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
    }

}

