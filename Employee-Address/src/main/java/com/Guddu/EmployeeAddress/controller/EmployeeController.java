package com.Guddu.EmployeeAddress.controller;

import com.Guddu.EmployeeAddress.model.Employee;
import com.Guddu.EmployeeAddress.service.EmployeeService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        return  employeeService.save(employee);

    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return  employeeService.deleteById(id);

    }
}
jr̥r̥