package com.udemy.c1.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
    //ejecuta primero
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        //comentario
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    // ejecuta despues
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception{
        //comentario
        long startTime = (long) request.getAttribute("startTime");
        LOG.info("--REQUEST URL:"+ request.getRequestURL().toString()+"--TOTAL TIME:"+(System.currentTimeMillis()-startTime)+"ms");
    }


}
