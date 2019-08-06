package com.kivicms.test.controllers;

import com.kivicms.test.models.Mark;
import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.MarkRepository;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/mark")
@Controller
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping
    public String main(Map<String, Object> model) {

        Iterable<Mark> marks = markRepository.findAll();
        model.put("marks", marks);

        Iterable<Vendor> vendorList = vendorRepository.findAll();
        model.put("vendorList", vendorList);

        String breadcrumbs[][] = new String[2][2];
        breadcrumbs[0][0] = "/mark";
        breadcrumbs[0][1] = "Модели";
        breadcrumbs[1][0] = "";
        breadcrumbs[1][1] = "Список";
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Модели");

        return "mark/index";
    }

    @PostMapping("/create")
    public String create(@RequestParam Vendor vendor, @RequestParam String name) {
        Mark mark = new Mark(vendor, name);
        markRepository.save(mark);
        return "redirect:/mark";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        markRepository.deleteById(id);
        return "redirect:/mark";
    }
}
