package com.example.serviceOne.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceOne")
@CrossOrigin("*")
public class LaunchController {

    private RestTemplate restTemplate;

    public LaunchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    @ResponseBody
    public String launchApp() {
        String serviceTwoString = getServiceTwoString("Attempt 1");
        return "Oh Hello, This is Service One!" + serviceTwoString;
    }

    public String getServiceTwoString(String id) {
        System.out.println("The id sent is: " + id);
        return this.restTemplate.getForObject("http://localhost:8082/serviceTwo", String.class);
    }
}
