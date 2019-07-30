package com.kivicms.test.controllers;

import com.kivicms.test.models.Renter;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "renter/index";
    }

    @GetMapping("/create")
    public String create() {
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
}
