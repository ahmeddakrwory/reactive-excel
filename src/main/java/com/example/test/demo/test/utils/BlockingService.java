package com.example.test.demo.test.utils;

import org.springframework.stereotype.Service;

@Service
public class BlockingService {
    public String fileisFinshed(){
        return  "File is finshed";
    }
}
