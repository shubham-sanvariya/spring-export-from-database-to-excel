package com.springframework.springexporttoexcel.repository;

import com.springframework.springexporttoexcel.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
