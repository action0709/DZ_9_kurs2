package com.pro.sky.DZ9_Kurs2.controller;

import com.pro.sky.DZ9_Kurs2.DZ9_Kurs2Application;
import com.pro.sky.DZ9_Kurs2.model.Employee;
import com.pro.sky.DZ9_Kurs2.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@GetMapping("/add")
    public Employee add(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName)
{
return employeeService.add(firstName,lastName);
}
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName)
    {
        return employeeService.remove(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName)
    {
        return employeeService.find(firstName,lastName);
    }

    @GetMapping("/all")
    public List<Employee> all() {
return employeeService.getAll();
    }

    @SpringBootApplication
    public static class Dz6Kurs2Application {
        public static void main(String[] args) {
            SpringApplication.run(DZ9_Kurs2Application.class, args);
        }

    }
}
