package com.prakash.controller;

import com.prakash.entity.Employee;
import com.prakash.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redish/api")
@EnableCaching
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity <Employee> addNewEmployee(@RequestBody Employee employee){

        Employee savedEmployee= this.employeeService.save(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity <List<Employee>> findAllEmployeeById(){
        List<Employee> allEmployee = this.employeeService.findAll();
        return new ResponseEntity<>(allEmployee,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @Cacheable(key ="#id",value ="employee")
    public Employee findEmployeeById(@PathVariable int id){
        Employee employeeWithGivenID = this.employeeService.findById(id);
        return employeeWithGivenID;
    }
    

    @DeleteMapping("/delete/{id}")
    public String  deleteEmployeeById(@PathVariable int id){
       this.employeeService.deleteById(id);
        return "Employee deleted with employee Id: "+id;
    }
    


}
