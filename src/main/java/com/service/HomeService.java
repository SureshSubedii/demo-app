package com.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String greet(String message){
        return message;
    }
}