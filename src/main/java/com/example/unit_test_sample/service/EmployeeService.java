package com.example.unit_test_sample.service;

import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee get(long id){
        if(id <= 0) return null;
        return employeeRepository.findById(id);
    }


    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }


    public Employee insert(Employee employee){
        if(employee == null) return null;
        return employeeRepository.save(employee);
    }


    public Employee update(Employee employee){
        if(employee == null || employee.getId() <= 0) return null;
        return employeeRepository.save(employee);
    }



    public boolean delete(Employee employee){
        if(employee == null || employee.getId()<=0) return false;
         employeeRepository.delete(employee);
         return true;
    }



}
