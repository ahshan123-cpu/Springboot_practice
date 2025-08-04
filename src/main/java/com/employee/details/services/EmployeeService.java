package com.employee.details.services;

import com.employee.details.entity.Employee;
import com.employee.details.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List<Employee> getEmployee() {
        return  employeeRepo.findAll();
    }
    public Optional<Employee> getEmployee(int id) {
        return employeeRepo.findById(id);
    }
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public String updateEmployee(int id, Employee employee) {
        Optional<Employee> optionalEmp = employeeRepo.findById(id);
        if (optionalEmp.isPresent()) {
            Employee emp = optionalEmp.get();
            emp.setName(employee.getName());
            emp.setDesignation(employee.getDesignation());
            emp.setSalary(employee.getSalary());
            emp.setStatus(employee.getStatus());
            emp.setWorkExperience(employee.getWorkExperience());
            employeeRepo.save(emp);
        }else{
            Logger logger = LoggerFactory.getLogger(EmployeeService.class);
            logger.error("Employee not found");
        }
        return "Employee Updated";
    }

    public String deleteEmployee(int id) {
        Optional<Employee> optionalEmp = employeeRepo.findById(id);
        optionalEmp.ifPresent(emp -> employeeRepo.delete(emp));
        return "Employee Deleted Successfully";
    }
}