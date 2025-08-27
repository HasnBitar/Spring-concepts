package com.project.lombok.projectLombok.mappers;

import com.project.lombok.projectLombok.entities.Beer;
import com.project.lombok.projectLombok.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
