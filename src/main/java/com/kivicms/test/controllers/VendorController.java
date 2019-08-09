package com.kivicms.test.controllers;

import com.kivicms.test.models.Breadcrumb;
import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping("/vendor")
    public String main(Map<String, Object> model) {

        Iterable<Vendor> vendors = vendorRepository.findAll();
        model.put("vendors", vendors);

        ArrayList<Breadcrumb> breadcrumbs = new ArrayList();
        breadcrumbs.add(new Breadcrumb("/vendor", "Производители"));
        breadcrumbs.add(new Breadcrumb("", "Список"));
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Производители");
        return "vendor/index";
    }

    @PostMapping("/vendor/create")
    public String create(@RequestParam String name, Map<String, Object> model) {
        Vendor vendor = new Vendor(name);
        vendorRepository.save(vendor);
        return "redirect:/vendor";
    }

    @GetMapping("/vendor/delete/{id}")
    public String delete(@PathVariable Integer id) {
        vendorRepository.deleteById(id);
        return "redirect:/vendor";
    }

}
