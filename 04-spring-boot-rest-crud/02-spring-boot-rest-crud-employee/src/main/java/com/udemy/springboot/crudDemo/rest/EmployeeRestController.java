package com.udemy.springboot.crudDemo.rest;

import com.udemy.springboot.crudDemo.dao.EmployeeDAO;
import com.udemy.springboot.crudDemo.entity.Employee;
import com.udemy.springboot.crudDemo.service.EmployeeService;
import com.udemy.springboot.crudDemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    //ex[pse employees and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for get empregado pelo empregado id
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    //add mapping for post /employess - add new employee
    @PostMapping("/employees/{employeeId}")
    public  Employee addEmployee(@RequestBody Employee employee){
        //
    }
}
