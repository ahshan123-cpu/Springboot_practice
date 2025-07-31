package com.employee.services;

import com.employee.details.entity.Employee;
import com.employee.details.repo.EmployeeRepo;
import com.employee.details.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setId(6);
        employee.setName("John");
        employee.setDesignation("Tester");
        employee.setSalary(10000.100);
        employee.setWorkExperience(4);
        employee.setStatus("Active");
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
        Employee emp = employeeService.createEmployee(employee);
        Assertions.assertEquals(employee.getId(),emp.getId());
        System.out.println("Adding Employee Successfully");
    }
}
