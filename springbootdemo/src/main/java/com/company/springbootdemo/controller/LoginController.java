package com.company.springbootdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    // GET REQUEST
    @GetMapping("/login")
    public String getLogin() {

        return "GET Request Called Successfully";
    }

    // POST REQUEST
    @PostMapping("/post")
    public String dataPosted(@RequestBody String data) {

        return "POST Request Called Successfully : " + data;
    }

    // DELETE REQUEST
    @DeleteMapping("/delete")
    public String dataDeleted() {

        return "DELETE Request Called Successfully";
    }

    // PUT REQUEST
    @PutMapping("/update")
    public String dataUpdated(@RequestBody String data) {

        return "PUT Request Called Successfully : " + data;
    }
}