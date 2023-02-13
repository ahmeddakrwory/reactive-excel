package com.example.test.demo.test;

import com.example.test.demo.test.historyService.HistoryService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Aspect
public class TestsAspect {
    @Autowired
    private HistoryService testController;
    @After("execution(* com.example.test.demo.test.historyService.HistoryService.date())")
    public void after(){
        System.out.println("excuted after");

    }
//    @Before("execution(* com.example.test.demo.test.TestController.gethql())")
//    public void before(){
//        System.out.println("excuted before");
//    }
////    @Around("execution(* com.example.test.demo.test.TestController.gethql())")
////    public void around(){
////        System.out.println("excuted around");
//    }
}
