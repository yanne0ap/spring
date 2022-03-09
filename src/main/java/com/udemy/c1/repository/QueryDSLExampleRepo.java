package com.udemy.c1.repository;

import org.springframework.stereotype.Repository;
import com.udemy.c1.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
    private  QCourse qCourse = QCourse.course;

}
