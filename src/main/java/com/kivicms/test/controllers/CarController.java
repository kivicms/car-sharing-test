package com.kivicms.test.controllers;

import com.kivicms.test.models.Car;
import com.kivicms.test.models.Mark;
import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.CarRepository;
import com.kivicms.test.repositories.MarkRepository;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public String index(Map<String, Object> model) {

        Iterable<Car> cars = carRepository.findAll();
        model.put("cars", cars);

        return "car/index";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {

        Iterable<Mark> marks = markRepository.findAll();
        model.put("markList", marks);

        Iterable<Vendor> vendorList = vendorRepository.findAll();
        model.put("vendorList", vendorList);

        return "car/create";
    }

    @PostMapping("/create")
    public String add(@RequestParam Vendor vendor, @RequestParam Mark mark, String number) {
        Car car = new Car(vendor, mark, number, 1);

        carRepository.save(car);

        return "redirect:/car";
    }
}
