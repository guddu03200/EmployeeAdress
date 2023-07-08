package com.Guddu.EmployeeAddress.controller;

import com.Guddu.EmployeeAddress.model.Address;
import com.Guddu.EmployeeAddress.service.AddressService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;




    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Object> getAddressById(@PathVariable("id") Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public String createAddress(@RequestBody Address address) {
        return addressService.save(address);

    }

    @PutMapping("/{id}")
    public String updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        return addressService.deleteById(id);

    }
}
