package com.employee.wireMockDemo.controller;

import com.employee.wireMockDemo.config.GithubConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GithubController {


    private final GithubConfig githubConfig;

    public GithubController(GithubConfig githubConfig) {
        this.githubConfig = githubConfig;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        return ResponseEntity.ok(githubConfig.getUserInfo(username));
    }
}
