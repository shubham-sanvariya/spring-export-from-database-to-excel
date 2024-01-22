package com.springframework.springexporttoexcel.controller;

import com.springframework.springexporttoexcel.service.CustomerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; fileName=Customers_Information.xlsx";

        response.setHeader(headerKey,headerValue);
        customerService.exportCustomerToExcel(response);
    }
}
