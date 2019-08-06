package com.kivicms.test.controllers;

import com.kivicms.test.repositories.CarRepository;
import com.kivicms.test.repositories.OperationRepository;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RenterRepository renterRepository;

    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("pageTitle", "Главная");

        model.put("carTotal", carRepository.count());
        model.put("renterTotal", renterRepository.count());
        model.put("operationTotal", operationRepository.count());

        return "home/index";
    }
}