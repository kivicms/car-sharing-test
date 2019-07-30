package com.kivicms.test.repositories;

import com.kivicms.test.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
