package com.example.unit_test_sample.controller;

import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.service.EmployeeService;
import com.example.unit_test_sample.utils.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

//@RequestMapping(produces = "application/json", value="api/v1/")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public Flux<List<Employee>> index(){
        return Flux.just(employeeService.getAll()).log();
    }


    @GetMapping("api/v1/employees")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }


    @GetMapping("api/v1/employees/{id}")
    public Employee get(@PathVariable(name = "id") String id){
        return employeeService.get(id);
    }


    @PostMapping("/api/v1/employees")
    public ResultStatus add(@RequestBody Employee employee){
        return ResultStatus.byNull(employeeService.insert(employee),"Record Added!", "Failed to add record");
    }



    @PutMapping("/api/v1/employees")
    public ResultStatus update(@RequestBody Employee employee){
        return ResultStatus.byNull(employeeService.update(employee), "Record Updated!", "Failed to update record");
    }


    @DeleteMapping("/api/v1/employees/{id}")
    public ResultStatus delete(@PathVariable(name = "id") String id){
        Employee employee = employeeService.get(id);
        return ResultStatus.byNull(employeeService.delete(employee), "Record Deleted!", "Failed to delete record");
    }




}
