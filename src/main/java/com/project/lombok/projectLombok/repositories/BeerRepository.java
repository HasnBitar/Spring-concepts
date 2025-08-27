package com.project.lombok.projectLombok.repositories;

import com.project.lombok.projectLombok.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
