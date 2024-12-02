package com.controller;


import com.DTO.RequestDTO;
import com.mapper.Destination;
import com.mapper.Source;
import com.mapper.SourceDestMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ApiController {
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



}
