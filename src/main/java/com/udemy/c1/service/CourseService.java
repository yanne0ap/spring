package com.udemy.c1.service;

import com.udemy.c1.entity.Course;

import java.util.List;

public interface CourseService {

    public abstract List<Course> ListAllCourses();
    public abstract Course addCourse(Course course);
    public abstract Course findCustomerById(int  id);
    public abstract void removeCourse(int id);
    public abstract Course updateCourse(Course course);

}
