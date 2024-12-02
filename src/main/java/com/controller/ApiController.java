package com.controller;


import com.DTO.RequestDTO;
import com.component.HomeComponent;
import com.mapper.Destination;
import com.mapper.Source;
import com.mapper.SourceDestMapper;
import com.service.HomeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")

public class ApiController {
    private final HomeComponent homeComponent;

    //Constructor based Dependency Injection
    public ApiController(HomeComponent homeComponent){
        this.homeComponent = homeComponent;
    }
    //Without constructor Dependency Injection
    @Autowired
    public HomeService homeService;


    @PostMapping(value = "/source", produces = "application/json")
    public ResponseEntity<Map<String, Object>> getData(@RequestBody RequestDTO requestData) {
        Source source = new Source(requestData.getName(), requestData.getDescription());
        SourceDestMapper mapper = Mappers.getMapper(SourceDestMapper.class);

        Destination dest = mapper.sourceToDestination(source);
        System.out.println("_______________________________________________________________________________________________________________" + dest.getName() + dest.getDescription());
        Map<String, Object> destination = new HashMap<>();
        destination.put("name", dest.getName());
        destination.put("description", dest.getDescription());


        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Source Copied to destination");
        response.put("destination", destination);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/message")
    public String getMessage(){
        return homeComponent.getMessage();

    }
    @GetMapping("/greetings/{num}")
    public String greet(@PathVariable("num") int num,@RequestParam(name = "value") String msg) {
        System.out.println(num);
        return homeService.greet(msg)  + num;

    }



}
