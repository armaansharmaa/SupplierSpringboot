package com.example.supplierproject;

import com.example.supplierproject.entity.Supplier;
import com.example.supplierproject.repository.SupplierRepository;
import com.example.supplierproject.service.SupplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

@SpringBootTest
class SupplierprojectApplicationTests {
@Autowired
private SupplierService supplierService;

	@MockBean
	private SupplierRepository supplierRepository;

	@Test
	public void testQuerySuppliers() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Supplier> suppliers = new PageImpl<>(Collections.emptyList());
		Mockito.when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
				"India", "small_scale", "3d_printing", pageable)).thenReturn(suppliers);

		Page<Supplier> result = supplierService.querySuppliers("India", "small_scale", "3d_printing", pageable);
		Assertions.assertEquals(0, result.getTotalElements());
	}
}
