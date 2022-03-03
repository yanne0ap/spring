package com.udemy.c1.component;

import com.udemy.c1.repository.CourseJpaRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    public void sayHello(){
        LOG.info("HELLO FROM EXAMPLECOMPONENT");
    }

}
