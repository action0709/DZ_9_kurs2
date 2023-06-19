package com.pro.sky.DZ11_kurs2.controller;

import com.pro.sky.DZ11_kurs2.model.Employee;
import com.pro.sky.DZ11_kurs2.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("salary") double salary)
    {
        return employeeService.add(new Employee(firstName, lastName,department,salary));
    }
//    @GetMapping("/remove")
//    public Employee remove(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName)
//    {
//        return employeeService.remove(firstName,lastName);
//    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName)
    {
        return employeeService.find(firstName,lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> all() {
return employeeService.getAll();
    }


}
