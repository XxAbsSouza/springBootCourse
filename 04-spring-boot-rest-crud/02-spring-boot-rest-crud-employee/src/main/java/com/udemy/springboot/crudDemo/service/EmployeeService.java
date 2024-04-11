package com.udemy.springboot.crudDemo.service;

import com.udemy.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
