package com.prakash.service;

import com.prakash.entity.Employee;
import com.prakash.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Override
    public Employee save(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteEmployee(id);
    }
}
