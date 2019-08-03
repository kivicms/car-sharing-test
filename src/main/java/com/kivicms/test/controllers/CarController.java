package com.kivicms.test.controllers;

import com.kivicms.test.models.Car;
import com.kivicms.test.models.Mark;
import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.CarRepository;
import com.kivicms.test.repositories.MarkRepository;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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

        String breadcrumbs[][] = new String[2][2];

        breadcrumbs[0][0] = "/car";
        breadcrumbs[0][1] = "Автомобили";
        breadcrumbs[1][0] = "";
        breadcrumbs[1][1] = "Список";

        model.put("breadcrumbs", breadcrumbs);

        return "car/index";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {

        Iterable<Mark> marks = markRepository.findAll();
        model.put("markList", marks);

        Iterable<Vendor> vendorList = vendorRepository.findAll();
        model.put("vendorList", vendorList);

        Car car = new Car(" ");
        model.put("car", car);

        return "car/create";
    }

    @PostMapping("/create")
    public String add(@RequestParam Vendor vendor, @RequestParam Mark mark, String number) {
        Car car = new Car(vendor, mark, number, 1);
        carRepository.save(car);
        return "redirect:/car";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Map<String, Object> model) {
        Car car = carRepository.findById(id).get();
        model.put("car", car);
        return "car/view";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable Integer id, Map<String, Object> model) {
        Car car = carRepository.findById(id).get();

        model.put("car", car);

        Iterable<Mark> marks = markRepository.findAll();
        model.put("markList", marks);

        Iterable<Vendor> vendorList = vendorRepository.findAll();
        model.put("vendorList", vendorList);

        return "car/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestParam Vendor vendor, @RequestParam Mark mark, String number) {
        Car car = carRepository.findById(id).get();
        car.setId(id);
        car.setVendor(vendor);
        car.setMark(mark);
        car.setNumber(number);
        carRepository.save(car);
        return "redirect:/car/view/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        carRepository.deleteById(id);
        return "redirect:/car";
    }
}
