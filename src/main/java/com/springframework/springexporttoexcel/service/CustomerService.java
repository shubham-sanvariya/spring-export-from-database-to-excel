package com.springframework.springexporttoexcel.service;

import com.springframework.springexporttoexcel.domain.Customer;
import com.springframework.springexporttoexcel.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Customer> customers = customerRepository.findAll();
        ExcelExportService exportService = new ExcelExportService(customers);
        exportService.exportDataToExcel(response);
        return customers;
    }
}
