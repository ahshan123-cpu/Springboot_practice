package com.employee.services;

import com.employee.details.entity.Employee;
import com.employee.details.repo.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setup(){
        employeeRepo.deleteAll();
    }
    @Test
    public void testAddEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setName("Saleem");
        emp.setDesignation("Developer");
        emp.setSalary(60000.0);
        emp.setWorkExperience(4);
        emp.setStatus("Active");

        mockMvc.perform(post("/employee").
                contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(emp))).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name").value("Saleem"));
    }
}
