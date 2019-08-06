package com.kivicms.test.controllers;

import com.kivicms.test.models.Car;
import com.kivicms.test.models.CarStat;
import com.kivicms.test.models.Renter;
import com.kivicms.test.models.RenterStat;
import com.kivicms.test.repositories.CarRepository;
import com.kivicms.test.repositories.OperationRepository;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequestMapping("/statistics")
@Controller
public class StatisticsController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private RenterRepository renterRepository;

    private String getTotalSecString() {
        Long totalSecs = operationRepository.getTimeSumByAllCars();

        return this.secondsToString(totalSecs);
    }

    private String secondsToString(Long seconds) {
        Long hours = seconds / 3600;
        Long minutes = (seconds % 3600) / 60;

        String totalTimeString = String.format("%d часов %02d минут", hours, minutes);
        return totalTimeString;
    }

    @GetMapping("/car")
    public String car(Map<String, Object> model) {
        model.put("pageTitle", "Статистика по аренде ТС");
        model.put("totalTimeString", this.getTotalSecString());

        ArrayList<CarStat> carStats = new ArrayList();
        
        Iterable<Car> cars = carRepository.findAll();

        Iterator<Car> iter = cars.iterator();

        while(iter.hasNext()) {
            Car car = iter.next();

            Long carTotalSec = operationRepository.getTimeSumByCar(car.getId());
            if (carTotalSec != null) {
                CarStat carStat = new CarStat(car, carTotalSec);
                carStats.add(carStat);
            }
        }

        model.put("carStats", carStats);

        return "statistics/car";
    }

    @GetMapping("/car/{id}")
    public String carDetails(@PathVariable Integer id, Map<String, Object> model) {
        Car car = carRepository.findById(id).get();
        model.put("pageTitle", "Статистика по аренде " + car.getFullCarName());
        return "statistics/car-details";
    }

    @GetMapping("/renter")
    public String renter(Map<String, Object> model) {
        model.put("pageTitle", "Статистика по арендаторам");
        model.put("totalTimeString", this.getTotalSecString());

        ArrayList<RenterStat> renterStats = new ArrayList();

        Iterable<Renter> renters = renterRepository.findAll();

        Iterator<Renter> iter = renters.iterator();

        while(iter.hasNext()) {
            Renter renter = iter.next();

            Long renterTotalSec = operationRepository.getTimeSumByRenter(renter.getId());
            if (renterTotalSec != null) {
                RenterStat renterStat = new RenterStat(renter, renterTotalSec);
                renterStats.add(renterStat);
            }
        }

        model.put("renterStats", renterStats);
        return "statistics/renter";
    }

    @GetMapping("/renter/{id}")
    public String RenterDetails(@PathVariable Integer id, Map<String, Object> model) {
        Renter renter = renterRepository.findById(id).get();
        model.put("pageTitle", "Статистика по арендатору " + renter.getFio());
        return "statistics/renter-details";
    }
}
