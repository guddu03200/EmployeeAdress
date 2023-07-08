package com.Guddu.EmployeeAddress.repo;

import com.Guddu.EmployeeAddress.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address, Long> {
}
