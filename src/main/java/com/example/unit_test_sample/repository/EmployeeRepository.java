package com.example.unit_test_sample.repository;

import com.example.unit_test_sample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
//public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    List<Employee> findBySalary(int salary);

    Employee findById(long id);

}
