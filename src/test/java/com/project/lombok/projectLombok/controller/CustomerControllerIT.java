package com.project.lombok.projectLombok.controller;

import com.project.lombok.projectLombok.entities.Customer;
import com.project.lombok.projectLombok.model.CustomerDTO;
import com.project.lombok.projectLombok.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {

    @Autowired
    CustomerController controller;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testCustomerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Customer customer = customerRepository.findAll().get(0);

        CustomerDTO customerDTO = controller.getCustomerById(customer.getId());

        assertThat(customerDTO).isNotNull();
    }

    @Test
    void listCustomers() {
        List<CustomerDTO> dtoList = controller.allCustomers();

        assertThat(dtoList.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @Rollback
    void testEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTO> dtos = controller.allCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

}