package com.project.lombok.projectLombok.services;

import com.project.lombok.projectLombok.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    boolean deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
