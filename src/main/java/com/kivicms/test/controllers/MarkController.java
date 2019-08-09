package com.kivicms.test.controllers;

import com.kivicms.test.models.Breadcrumb;
import com.kivicms.test.models.Mark;
import com.kivicms.test.models.Vendor;
import com.kivicms.test.repositories.MarkRepository;
import com.kivicms.test.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

        ArrayList<Breadcrumb> breadcrumbs = new ArrayList();
        breadcrumbs.add(new Breadcrumb("/mark", "Модели"));
        breadcrumbs.add(new Breadcrumb("", "Список"));
        model.put("breadcrumbs", breadcrumbs);

        model.put("pageTitle", "Модели");

        return "mark/index";
    }

    @PostMapping("/create")
    public String create(@RequestParam Integer vendorId, @RequestParam String name) {
        Vendor vendor = vendorRepository.findById(vendorId).get();

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
