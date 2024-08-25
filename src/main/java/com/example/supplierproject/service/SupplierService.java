package com.example.supplierproject.service;

import com.example.supplierproject.entity.Supplier;
import com.example.supplierproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> querySuppliers(String location, String natureOfBusiness, String manufacturingProcesses,
            Pageable pageable) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(location, natureOfBusiness,
                manufacturingProcesses, pageable);
    }
}