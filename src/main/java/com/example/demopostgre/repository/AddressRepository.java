package com.example.demopostgre.repository;

import com.example.demopostgre.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
