package com.example.unit_test_sample.controller;

import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.persistence.EntityManager;
import java.util.List;

//@RequestMapping(produces = "application/json", value="api/v1/")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@Autowired EntityManager entityManager;


    @GetMapping("")
    public Flux<List<Employee>> index(){
//        System.out.println("----------------EntityManager--------------------");
//        System.out.println(entityManager);
//        System.out.println("----------------EntityManager--------------------");

        return Flux.just(employeeService.getAll()).log();
    }




    @GetMapping("api/v1/employees")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }




    @GetMapping("api/v1/employees/{id}")
    public Employee get(@PathVariable(name = "id") int id){
        return employeeService.get(id);
    }








    @PostMapping("/api/v1/employees")
    public Employee add(@RequestBody Employee employee){
        return employeeService.insert(employee);//? "Record Added!": "Failed to add record";
    }




    @PutMapping("/api/v1/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);//? "Record Updated!": "Failed to update record";
    }



    @DeleteMapping("/api/v1/employees/{id}")
    public String delete(@PathVariable(name = "id") long id){
        Employee employee = employeeService.get(id);
        return employeeService.delete(employee)? "Record Deleted!": "Failed to delete record";
    }




}
