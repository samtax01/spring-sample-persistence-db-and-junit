package com.example.unit_test_sample.repository;

import com.example.unit_test_sample.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
//@Transactional
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findBySalary(int salary);

    default Employee findByIdOrFail(String id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
