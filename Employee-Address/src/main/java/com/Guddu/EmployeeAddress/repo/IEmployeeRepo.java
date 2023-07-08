package com.Guddu.EmployeeAddress.repo;

import com.Guddu.EmployeeAddress.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee, Long> {
}
