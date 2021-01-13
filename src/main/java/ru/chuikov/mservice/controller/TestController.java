package ru.chuikov.mservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"","/"})
public class TestController {

    @GetMapping
    @PreAuthorize("authenticated()")
    public Map<?,?> hello(){
        Map<String,String> map= new HashMap<>();
        map.put("Status","OK");
        return map;
    }
}
