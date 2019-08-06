package com.kivicms.test.controllers;

import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping("/vendor")
    public String main(Map<String, Object> model) {

        Iterable<Vendor> vendors = vendorRepository.findAll();
        model.put("vendors", vendors);

        String breadcrumbs[][] = new String[2][2];
        breadcrumbs[0][0] = "/vendor";
        breadcrumbs[0][1] = "Производители";
        breadcrumbs[1][0] = "";
        breadcrumbs[1][1] = "Список";
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Производители");
        return "vendor/index";
    }

    @PostMapping("/vendor/create")
    public String create(@RequestParam String name, Map<String, Object> model) {
        Vendor vendor = new Vendor(name);

        vendorRepository.save(vendor);

        Iterable<Vendor> vendors = vendorRepository.findAll();
        model.put("vendors", vendors);

        return "vendor/index";
    }

    @GetMapping("/vendor/delete/{id}")
    public String delete(@PathVariable Integer id) {
        vendorRepository.deleteById(id);
        return "redirect:/vendor";
    }

}
