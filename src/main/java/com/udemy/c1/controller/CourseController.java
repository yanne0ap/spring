package com.udemy.c1.controller;

import com.udemy.c1.converter.CourseConverter;
import com.udemy.c1.entity.Course;
import com.udemy.c1.model.CourseModel;
import com.udemy.c1.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {


    private static final String COURSE_VIEW = "courses";
    private static final String COURSE_EDIT = "editar";
    private static final Log LOG = LogFactory.getLog(CourseController.class);


    @Autowired
    @Qualifier("courseServiceImp")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView ListAllCourses() {
        LOG.info("Call: " + "ListAllCourses()");
        List<Course> courseList = courseService.ListAllCourses();

        List<CourseModel> modelList = courseList
                        .stream()
                        .map(CourseConverter::entity2model)
                        .collect(Collectors.toList());

        List<CourseModel> modelList2 = new ArrayList<>();
        for( int x = 0; x < courseList.size(); x++) {
            CourseModel model = CourseConverter.entity2model(courseList.get(x));
            modelList2.add(model);
        }

        //modelList.forEach(x -> System.out.println(x.toString()));
        modelList2.forEach(x -> System.out.println(x.toString()));
        ModelAndView mva = new ModelAndView(COURSE_VIEW);
        mva.addObject("courses", modelList2);
        mva.addObject("Course", new Course());
        return mva;
    }


    @PostMapping("/addcourse")
    public  String addCourse(@ModelAttribute("course") CourseModel courseModel){
         LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
         Course course = CourseConverter.model2entity(courseModel);
         courseService.addCourse(course);
        return "redirect:/courses/listcourses";
     }


    //localhost:8080/example2/request1/JON/22
    @GetMapping("/edit/{id}")
    public ModelAndView request2(@PathVariable(value = "id", required = false) int id){
        ModelAndView mav = new ModelAndView(COURSE_EDIT);
        CourseModel model = CourseConverter.entity2model(courseService.findCustomerById(id));
        mav.addObject("course", model);
        return mav;
    }

    @PostMapping("/updatecourse")
    public  String updateCourse(@ModelAttribute("course") CourseModel courseModel){
        LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
        Course course = CourseConverter.model2entity(courseModel);
        courseService.updateCourse(course);
        return "redirect:/courses/listcourses";
    }

    @GetMapping("/delatecourse/{id}")
    public ModelAndView delate(@PathVariable(value = "id", required = false) int id){
        courseService.removeCourse(id);
        return ListAllCourses() ;
    }
//    @PostMapping("/addcourse")
//    public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
//        LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
//        courseService.addCourse(courseModel);
//        return "redirect:/courses/listcourses";
//    }

}

