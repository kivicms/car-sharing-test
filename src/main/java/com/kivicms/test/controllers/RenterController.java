package com.kivicms.test.controllers;

import com.kivicms.test.models.Renter;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/renter")
@Controller
public class RenterController {

    @Autowired
    private RenterRepository renterRepository;

    @GetMapping
    public String index(Map<String, Object> model) {
        Iterable<Renter> renters = renterRepository.findAll();
        model.put("renters", renters);
        String breadcrumbs[][] = new String[2][2];
        breadcrumbs[0][0] = "/renter";
        breadcrumbs[0][1] = "Арендаторы";
        breadcrumbs[1][0] = "";
        breadcrumbs[1][1] = "Список";
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Арендаторы");
        return "renter/index";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {

        String breadcrumbs[][] = new String[2][2];
        breadcrumbs[0][0] = "/renter";
        breadcrumbs[0][1] = "Арендаторы";
        breadcrumbs[1][0] = "";
        breadcrumbs[1][1] = "Добавить";
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Арендаторы");
        return "renter/create";
    }

    @PostMapping("/create")
    public String add(
            @RequestParam String fio,
            @RequestParam String passport,
            @RequestParam String address,
            @RequestParam String phone
    ) {
        Renter renter = new Renter(fio, passport, address, phone);
        renterRepository.save(renter);
        return "redirect:/renter";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        renterRepository.deleteById(id);
        return "redirect:/renter";
    }
}
