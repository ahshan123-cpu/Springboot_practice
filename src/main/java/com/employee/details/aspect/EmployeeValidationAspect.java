package com.employee.details.aspect;

import com.employee.details.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeValidationAspect  {
    @Before("execution(* com.employee.details.services.EmployeeService.createEmployee(..)) || " +
            "execution(* com.employee.details.services.EmployeeService.updateEmployee(..))")

    public void validateWorkExperience(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Employee emp) {
                if (emp.getWorkExperience() < 3) {
                    throw new IllegalArgumentException("Work experience must be at least 3 years.");
                }
            }
        }
    }
}
