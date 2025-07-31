package com.employee.details.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Designation")
    private String designation;
    @Column(name = "Salary")
    private Double salary;
    @Column(name = "Experiance")
    private int workExperience;
    @Column(name = "Status")
    private String status;

    public Employee(Employee employee) {
    }
}
