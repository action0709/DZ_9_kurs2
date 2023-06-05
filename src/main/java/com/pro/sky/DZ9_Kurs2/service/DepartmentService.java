package com.pro.sky.DZ9_Kurs2.service;

import com.pro.sky.DZ9_Kurs2.exception.EmployeeNotFoundException;
import com.pro.sky.DZ9_Kurs2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee getEmployeeWithMaxSalary (int department) {
       return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    public Employee getEmployeeWithMinSalary (int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
}
