package com.Guddu.EmployeeAddress.service;


import com.Guddu.EmployeeAddress.model.Address;
import com.Guddu.EmployeeAddress.repo.IAddressRepo;
import com.Guddu.EmployeeAddress.repo.IEmployeeRepo;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
   IAddressRepo iAddRepo;
    public List<Address> findAll() {
        return (List<Address>) iAddRepo.findAll();
    }

    public Optional<Object> findById(Long id) {
        return Optional.of(iAddRepo.findById(id));
    }

    public String save(Address address) {
        iAddRepo.save(address);
        return "Saved Successfully";
    }

    public String updateAddress(Long id, Address address) {
        Address existingAddress = iAddRepo.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setAddName(address.getAddName());
            iAddRepo.save(existingAddress);
            return "Address updated successfully";
        }
        return "Address not found";
    }

    public String deleteById(Long id) {
        iAddRepo.deleteById(id);
        return "Deleted Sucsessfully";
    }
}
