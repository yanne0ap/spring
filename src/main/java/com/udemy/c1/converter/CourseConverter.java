package com.udemy.c1.converter;

import com.udemy.c1.entity.Course;
import com.udemy.c1.model.CourseModel;

public class CourseConverter {
    //Entity --> model
    public static CourseModel entity2model(Course course){
        CourseModel courseModel = new CourseModel();
        courseModel.setId(course.getId());
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setHours(course.getHours());
        courseModel.setPrice(course.getPrice());
        return courseModel;
    }

    //Model --> Entity
    public static Course model2entity(CourseModel courseModel){
        Course course = new Course();
        course.setId(courseModel.getId());
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setHours(courseModel.getHours());
        course.setPrice(courseModel.getPrice());
        return course;
    }
}
