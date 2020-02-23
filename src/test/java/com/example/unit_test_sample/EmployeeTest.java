package com.example.unit_test_sample;


import com.example.unit_test_sample.model.Employee;
import com.example.unit_test_sample.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@WebFluxTest
@DataJpaTest
public class EmployeeTest {

    //@Autowired
    //private WebTestClient webTestClient;

    @Autowired
    private TestEntityManager testEntityManager;


    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void testFindByName() {
        // build employee
        Employee testEmployee = Employee.builder()
                .firstName("Samson")
                .lastName("Isaac")
                .jobTitle("Developer")
                .salary(50)
                .build();

        // add to memory
        testEntityManager.persist(testEmployee);

        // fetch all
        employeeRepository.findAll().forEach(System.out::println);
        List<Employee> employees = employeeRepository.findBySalary(50);

        // test
        assertEquals(1, employees.size());
        assertThat(employees).extracting(Employee::getSalary).containsOnly(50);
    }


    @Test
    public void indexTest() {
//        webTestClient.get().uri("")
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus().isOk()
//            .expectBodyList(Integer.class)
//            .hasSize(1);
    }



}
