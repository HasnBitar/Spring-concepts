package com.project.lombok.projectLombok.repositories;

import com.project.lombok.projectLombok.entities.Beer;
import com.project.lombok.projectLombok.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer With A Very Long Name Exceeding Fifty Characters 133234234234234234234234234234234234234234234234234234234234234234234234234234234234234234")
                    .beerStyle(BeerStyle.DARK)
                    .upc("123456789012")
                    .price(new java.math.BigDecimal("9.99"))
                    .build());

            beerRepository.flush();
        });

    }


    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("My Beer")
                        .beerStyle(BeerStyle.DARK)
                        .upc("123456789012")
                        .price(new java.math.BigDecimal("9.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

}