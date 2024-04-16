package com.udemy.springboot.crudDemo.dao;

import com.udemy.springboot.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members") //--> muda o endpoint para o escrito entre ""
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //JpaRepository<Employee - nossa classe, Integer - id da classe>
}
