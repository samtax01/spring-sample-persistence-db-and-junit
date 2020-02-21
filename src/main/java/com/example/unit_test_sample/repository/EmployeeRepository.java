package com.example.unit_test_sample.repository;

import com.example.unit_test_sample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findBySalary(int salary);

    Employee findById(long id);


}
