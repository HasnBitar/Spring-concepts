package com.project.lombok.projectLombok.services;

import com.project.lombok.projectLombok.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> allCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateById(UUID customerId, CustomerDTO customer);

    void deleteById(UUID customerId);
}
