package com.project.lombok.projectLombok.bootstrap;

import com.project.lombok.projectLombok.entities.Beer;
import com.project.lombok.projectLombok.entities.Customer;
import com.project.lombok.projectLombok.model.BeerStyle;
import com.project.lombok.projectLombok.model.CustomerDTO;
import com.project.lombok.projectLombok.repositories.BeerRepository;
import com.project.lombok.projectLombok.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
            Customer customer1 = Customer.builder()
                    .customerName("Hasan")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("Hazem")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1,customer2));
        }
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    .beerName("Galaxy")
                    .beerStyle(BeerStyle.DARK)
                    .upc("123456")
                    .price(new BigDecimal(123))
                    .quantityOnHand(100)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Krombacher")
                    .beerStyle(BeerStyle.WHITE)
                    .upc("7890")
                    .price(new BigDecimal(200))
                    .quantityOnHand(150)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
            beerRepository.save(beer1);
            beerRepository.save(beer2);
        }
    }
}
