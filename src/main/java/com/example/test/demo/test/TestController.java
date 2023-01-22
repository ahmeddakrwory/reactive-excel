package com.example.test.demo.test;

import com.example.test.demo.test.entitys.TtUser;

//import javax.annotation.Resource;
//import java.io.*;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.core.io.InputStreamResource;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
import com.example.test.demo.test.repos.UserRepo;
import com.example.test.demo.test.utils.*;
import com.google.common.io.Files;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    private static File file;
    @Autowired
    private CsvWriterService csvWriterService;
    private static List<TtUser> users;
    @Autowired
    private UserRepo repo;
    @GetMapping( value = "/getAllusers", produces = {"application/stream+json"})
    public Disposable prepare() {
        Flux<TtUser> all=repo.findAll();
        users=new ArrayList<TtUser>();
        return  all.subscribe(valus->{
            System.out.println("AAA" + valus.getFirstName());
            users.add(valus);});
        }


    @GetMapping(value = "/download")
    @ResponseBody
    public ResponseEntity<Mono<Resource>> downloadCsv() {
        String fileName = String.format("%s.csv", RandomStringUtils.randomAlphabetic(10));
        csvWriterService.setAll(data());
        return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION,  "attachment; filename=" + fileName)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(csvWriterService.generateCsv()
                        .flatMap(x -> {
                            Resource resource = new InputStreamResource(x);
                            return Mono.just(resource);
                        }));
    }
    public List<TtUser> data(){return users;}

    }

