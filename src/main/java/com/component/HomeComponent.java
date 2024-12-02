package com.component;

import org.springframework.stereotype.Component;

@Component
public class HomeComponent {
    public String getMessage(){
        return "Hello from the HomeComponent";
    }
}
