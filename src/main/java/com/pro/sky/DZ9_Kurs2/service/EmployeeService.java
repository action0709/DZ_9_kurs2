package com.pro.sky.DZ9_Kurs2.service;

import com.pro.sky.DZ9_Kurs2.exception.EmployeeAlreadyAddedException;
import com.pro.sky.DZ9_Kurs2.exception.EmployeeNotFoundException;
import com.pro.sky.DZ9_Kurs2.exception.EmployeeStorageIsFullException;
import com.pro.sky.DZ9_Kurs2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap();
    final static private int MAX_SIZE = 5;

    public Employee add(String firstName, String lastName,int department,double salary) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employeeToAdd = new Employee(firstName, lastName,department,salary);
        if (employees.containsKey(createKey(firstName,lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(firstName,lastName),employeeToAdd);
        return employeeToAdd;
    }

//    public Employee remove(String firstName, String lastName) {
//        Employee employeeToRemove = new Employee(firstName, lastName);
//        if (!employees.containsKey(createKey(firstName,lastName))) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.remove(createKey(firstName, lastName));
//    }

    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName,lastName))){
        throw new EmployeeNotFoundException();
    }
        return employees.get(createKey(firstName, lastName));
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    private String createKey(String firstName,String lastName) {
        return (firstName + lastName).toLowerCase();
    }
}


