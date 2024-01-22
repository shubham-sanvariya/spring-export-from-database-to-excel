package com.springframework.springexporttoexcel.dataloader;

import com.springframework.springexporttoexcel.domain.Address;
import com.springframework.springexporttoexcel.domain.Customer;
import com.springframework.springexporttoexcel.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SeedData {
    private CustomerRepository customerRepository;

    public SeedData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private List<Customer> customers = Arrays.asList(
            new Customer("Sam", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Annie", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("John", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Jessica", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Anita", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Jacobs", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("White", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Black", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Forrest", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address")),
            new Customer("Sally", "Jefferson", "sam@email.com", new Address("Japan", "some state", " some city","The street address"))
    );

//     @PostConstruct
    public void saveCustomers(){
        customerRepository.saveAll(customers);
    }
}
