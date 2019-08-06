package com.kivicms.test.controllers;

import com.kivicms.test.models.Car;
import com.kivicms.test.models.Operation;
import com.kivicms.test.models.Renter;
import com.kivicms.test.repositories.CarRepository;
import com.kivicms.test.repositories.OperationRepository;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/operation")
@Controller
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RenterRepository renterRepository;

    @GetMapping()
    public String main(Map<String, Object> model) {
        Iterable<Operation> operations = operationRepository.findAll();
        model.put("operations", operations);
        model.put("pageTitle", "Операции с ТС");
        return "operation/index";
    }

    @GetMapping("/issue")
    public String issue(Map<String, Object> model) {
        Iterable<Car> cars = carRepository.findAll();
        model.put("cars", cars);

        Iterable<Renter> renters = renterRepository.findAll();
        model.put("renters", renters);

        model.put("pageTitle", "Выдать ТС");
        return "operation/issue";
    }

    @PostMapping("/issue")
    public String issueAdd(@RequestParam Car car, @RequestParam Renter renter) {
        Operation operation = new Operation(car, renter);
        operationRepository.save(operation);

        car.setRenter(operation.getRenter());
        car.setStatus(1);
        carRepository.save(car);
        return "redirect:/operation";
    }

    @GetMapping("/accept/{id}")
    public String accept(@PathVariable Integer id) {
        Operation operation = operationRepository.findById(id).get();
        operation.setEndDateTime(LocalDateTime.now());
        operationRepository.save(operation);

        Car car = operation.getCar();
        car.setStatus(0);
        carRepository.save(car);

        return "redirect:/operation";
    }
}

