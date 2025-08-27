package com.project.lombok.projectLombok.mappers;

import com.project.lombok.projectLombok.entities.Customer;
import com.project.lombok.projectLombok.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
