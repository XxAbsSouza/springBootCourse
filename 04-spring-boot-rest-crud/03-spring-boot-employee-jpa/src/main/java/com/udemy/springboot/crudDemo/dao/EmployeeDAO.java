package com.udemy.springboot.crudDemo.dao;

import com.udemy.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}


