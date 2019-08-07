package com.kivicms.test.api;

import com.kivicms.test.models.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarsRepository extends PagingAndSortingRepository<Car, Long> {

}
