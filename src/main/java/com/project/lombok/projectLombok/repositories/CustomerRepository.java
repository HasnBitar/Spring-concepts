package com.project.lombok.projectLombok.repositories;

import com.project.lombok.projectLombok.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
