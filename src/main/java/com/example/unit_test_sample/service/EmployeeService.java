package com.example.unit_test_sample.service;

import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee get(String id){
        return (id == null)? null: employeeRepository.findByIdOrFail(id);
    }


    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }


    public Employee insert(Employee employee){
        return (employee == null)? null: employeeRepository.save(employee);
    }


    public Employee update(Employee employee){
        return (employee == null || employee.getId().isEmpty())? null: employeeRepository.save(employee);
    }



    public boolean delete(Employee employee){
        if(employee == null) return false;
        employeeRepository.delete(employee);
        return true;
    }



}
