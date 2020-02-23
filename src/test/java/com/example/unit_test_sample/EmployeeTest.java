package com.example.unit_test_sample;


import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@WebFluxTest
//@DataJpaTest
@DataMongoTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void testFindByName() {

        // fetch all
        employeeRepository.findAll().forEach(System.out::println);
        List<Employee> employees = employeeRepository.findBySalary(50);

        // test
        assertEquals(3, employees.size());
        assertThat(employees).extracting(Employee::getSalary).containsOnly(50);
    }




}
