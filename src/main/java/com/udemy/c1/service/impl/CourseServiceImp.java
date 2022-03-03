package com.udemy.c1.service.impl;

import com.udemy.c1.entity.Course;
import com.udemy.c1.repository.CourseJpaRepository;
import com.udemy.c1.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImp")
public class CourseServiceImp implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImp.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> ListAllCourses() {
        LOG.info("Call: " + "ListAllCourses()");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: "+ "addCourse()");
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(Course course) {
        courseJpaRepository.delete(course);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJpaRepository.save(course);
    }


}
