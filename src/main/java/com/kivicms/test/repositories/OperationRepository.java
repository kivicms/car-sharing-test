package com.kivicms.test.repositories;

import com.kivicms.test.models.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Integer> {

    @Query(value = "SELECT sum(TIME_TO_SEC(timediff(end_date_time, start_date_time))) " +
            "FROM operation o WHERE end_date_time is NOT NULL", nativeQuery = true)
    Long getTimeSumByAllCars();

    @Query(value = "SELECT sum(TIME_TO_SEC(timediff(end_date_time, start_date_time))) " +
            "FROM operation o WHERE end_date_time is NOT NULL AND car_id=:carId", nativeQuery = true)
    Long getTimeSumByCar(Integer carId);

    @Query(value = "SELECT sum(TIME_TO_SEC(timediff(end_date_time, start_date_time))) " +
            "FROM operation o WHERE end_date_time is NOT NULL AND renter_id=:renterId", nativeQuery = true)
    Long getTimeSumByRenter(Integer renterId);

}
