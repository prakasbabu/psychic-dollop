package com.prakash.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.prakash.entity.Employee;

@Repository
public class EmployeeDao {
    @Autowired
   @Qualifier("redisTemplate")
    private RedisTemplate template;

    private final String HASH_KEY = "employee";
    
    public Employee save(Employee employee) {

        template.opsForHash().put(HASH_KEY, employee.getId(), employee);

        return employee;
    }
  public List findAllEmployees(){

        return template.opsForHash().values(HASH_KEY);
    }

    public Employee findEmployeeById(int id) {
    	System.out.println("Db called ");
        return (Employee) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteEmployee (int id) {

        template.opsForHash().delete(HASH_KEY, id);
        return "employee deleted";
    }

}
