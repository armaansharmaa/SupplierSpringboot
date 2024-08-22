package com.example.supplierproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="supplier")

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    Integer supplierId;
    @Column(name = "company_name")
    String companyName;
    @Column(name = "website")
    String website;
    @Column(name = "location")
    String location;
    @Column(name = "nature_of_business")
    String natureOfBusiness;
    @Column(name = "manufacturing_processes")
    String manufacturingProcesses;
}
