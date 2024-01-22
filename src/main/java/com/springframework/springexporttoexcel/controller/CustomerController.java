package com.springframework.springexporttoexcel.controller;

import com.springframework.springexporttoexcel.service.CustomerService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;

@Controller
@RequestMapping("/customers")
@AllArgsConstructor
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
