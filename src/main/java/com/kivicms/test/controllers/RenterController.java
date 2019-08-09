package com.kivicms.test.controllers;

import com.kivicms.test.models.Breadcrumb;
import com.kivicms.test.models.Renter;
import com.kivicms.test.repositories.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

        ArrayList<Breadcrumb> breadcrumbs = new ArrayList();
        breadcrumbs.add(new Breadcrumb("/renter", "Арендаторы"));
        breadcrumbs.add(new Breadcrumb("", "Список"));
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Арендаторы");
        return "renter/index";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {

        ArrayList<Breadcrumb> breadcrumbs = new ArrayList();
        breadcrumbs.add(new Breadcrumb("/renter", "Арендаторы"));
        breadcrumbs.add(new Breadcrumb("", "Добавить"));
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
