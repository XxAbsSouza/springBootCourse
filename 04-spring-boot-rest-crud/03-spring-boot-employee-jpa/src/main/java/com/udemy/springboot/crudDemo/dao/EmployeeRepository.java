package com.udemy.springboot.crudDemo.dao;

import com.udemy.springboot.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //JpaRepository<Employee - nossa classe, Integer - id da classe>
}
