package com.employee.services;

import com.employee.wireMockDemo.config.GithubConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class TestGithub {

    @Autowired
    private GithubConfig githubConfig;

    @Test
    public void testGithub(){
        Map<String, Object> map = githubConfig.getUserInfo("ahshan123-cpu");
        Assertions.assertEquals("ahshan123-cpu", map.get("login"));
        System.out.println("Tested successfully");
    }
}