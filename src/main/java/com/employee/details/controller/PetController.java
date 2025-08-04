package com.employee.details.controller;

import com.employee.details.services.PetStoreClientConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PetController {

    private final PetStoreClientConfig petStoreClientConfig;


    public PetController(PetStoreClientConfig petStoreClientConfig) {
        this.petStoreClientConfig = petStoreClientConfig;
    }

    @GetMapping("/getPet/{id}")
    public Map<String, Object> getPets(@PathVariable Long id) {
        return (Map<String, Object>) petStoreClientConfig.getPetById(id);
    }
}
