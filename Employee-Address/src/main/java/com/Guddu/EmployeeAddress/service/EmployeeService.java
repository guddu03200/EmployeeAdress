package com.Guddu.EmployeeAddress.service;

import com.Guddu.EmployeeAddress.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmpRepo;

    public List<Employee> findAll() {
        return (List<Employee>) iEmpRepo.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return iEmpRepo.findById(id);
    }

    public String save(Employee employee) {
        iEmpRepo.save(employee);
        return "save success";
    }

    public String updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = iEmpRepo.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setAddress(employee.getAddress());
            iEmpRepo.save(existingEmployee);
            return "Employee updated successfully";
        }
        return "Employee not found";
    }


    public String deleteById(Long id) {
        iEmpRepo.deleteById(id);
        return"delete success";
    }
}
