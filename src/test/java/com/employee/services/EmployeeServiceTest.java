package com.employee.services;

import com.employee.details.entity.Employee;
import com.employee.details.repo.EmployeeRepo;
import com.employee.details.services.EmployeeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    EmployeeService employeeService;

    private static Employee employee = null;

    @BeforeAll //it will execute first execution of code
    public static void init(){
        System.out.println("Hello, this is first execution or initialization");
        employee = new Employee();
        employee.setId(1);
        employee.setName("Alam");
        employee.setDesignation("Developer");
        employee.setSalary(10000.100);
        employee.setWorkExperience(3);
        employee.setStatus("Active");
    }

    @AfterAll
    public static void last(){
        System.out.println("Hello, this is last execution or initialization");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each execution");
    }


    @Test
    public void testCreateEmployee() {
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
        Employee emp = employeeService.createEmployee(employee);
        Assertions.assertNotNull(emp);
        Assertions.assertEquals(employee.getId(),emp.getId());
        Assertions.assertEquals(employee.getName(),emp.getName());
        Assertions.assertTrue(employee.getId()==1);
        System.out.println("Adding Employee Successfully");
    }

    @Test
    public void testDeleteEmployee() {
        Mockito.when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));
        Mockito.doNothing().when(employeeRepo).delete(employee);
        String result = employeeService.deleteEmployee(1);
        Mockito.verify(employeeRepo, Mockito.times(1)).findById(1);
        Mockito.verify(employeeRepo, Mockito.times(1)).delete(employee);
        System.out.println("Delete Employee Successfully");
    }

    @Test
    public void testUpdateEmployee() {
        Mockito.when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(employee);
        String result = employeeService.updateEmployee(employee.getId(), employee);
        Mockito.verify(employeeRepo, Mockito.times(1)).findById(1);
        Mockito.verify(employeeRepo, Mockito.times(1)).save(employee);
        System.out.println("Update Employee Successfully");

    }
}
