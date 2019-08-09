package com.kivicms.test.controllers

import com.kivicms.test.models.Breadcrumb
import com.kivicms.test.models.Car
import com.kivicms.test.repositories.CarRepository
import com.kivicms.test.repositories.MarkRepository
import com.kivicms.test.repositories.VendorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import java.util.ArrayList

@RequestMapping("/car")
@Controller
class CarController {

    @Autowired
    private val markRepository: MarkRepository? = null

    @Autowired
    private val vendorRepository: VendorRepository? = null

    @Autowired
    private val carRepository: CarRepository? = null

    @GetMapping
    fun index(model: MutableMap<String, Any>): String {

        val cars = carRepository!!.findAll()
        model["cars"] = cars

        val breadcrumbs = ArrayList<Breadcrumb>()
        breadcrumbs.add(Breadcrumb("/car", "Автомобили"))
        breadcrumbs.add(Breadcrumb("", "Список"))
        model["breadcrumbs"] = breadcrumbs

        model["pageTitle"] = "Автомобили"
        return "car/index"
    }

    @GetMapping("/create")
    fun create(model: MutableMap<String, Any>): String {

        val marks = markRepository!!.findAll()
        model["markList"] = marks

        val vendorList = vendorRepository!!.findAll()
        model["vendorList"] = vendorList

        val car = Car(" ")
        model["car"] = car

        val breadcrumbs = ArrayList<Breadcrumb>()
        breadcrumbs.add(Breadcrumb("/car", "Автомобили"))
        breadcrumbs.add(Breadcrumb("", "Добавить"))
        model["breadcrumbs"] = breadcrumbs

        model["pageTitle"] = "Добавить автомобиль"
        return "car/create"
    }

    @PostMapping("/create")
    fun add(@RequestParam vendorId: Int?, @RequestParam markId: Int?, number: String): String {
        val vendor = vendorRepository!!.findById(vendorId).get()
        val mark = markRepository!!.findById(markId).get()
        val car = Car(vendor, mark, number, 0)
        carRepository!!.save(car)
        return "redirect:/car"
    }

    @GetMapping("/view/{id}")
    fun view(@PathVariable id: Int?, model: MutableMap<String, Any>): String {
        val car = carRepository!!.findById(id).get()
        model["car"] = car

        val breadcrumbs = ArrayList<Breadcrumb>()
        breadcrumbs.add(Breadcrumb("/car", "Автомобили"))
        breadcrumbs.add(Breadcrumb("", "Просмотр: " + car.number))
        model["breadcrumbs"] = breadcrumbs

        model["pageTitle"] = "Просмотр автомобиля:" + car.number
        return "car/view"
    }

    @GetMapping("/update/{id}")
    fun edit(@PathVariable id: Int?, model: MutableMap<String, Any>): String {
        val car = carRepository!!.findById(id).get()

        model["car"] = car

        val marks = markRepository!!.findAll()
        model["markList"] = marks

        val vendorList = vendorRepository!!.findAll()
        model["vendorList"] = vendorList

        val breadcrumbs = ArrayList<Breadcrumb>()
        breadcrumbs.add(Breadcrumb("/car", "Автомобили"))
        breadcrumbs.add(Breadcrumb("", "Редактирование: " + car.number))
        model["breadcrumbs"] = breadcrumbs

        model["pageTitle"] = "Редактирование автомобиля:" + car.number
        return "car/update"
    }

    @PostMapping("/update/{id}")
    fun update(@PathVariable id: Int?, @RequestParam vendorId: Int?, @RequestParam markId: Int?, number: String): String {
        val vendor = vendorRepository!!.findById(vendorId).get()
        val mark = markRepository!!.findById(markId).get()
        val car = carRepository!!.findById(id).get()
        car.id = id
        car.vendor = vendor
        car.mark = mark
        car.number = number
        carRepository.save(car)
        return "redirect:/car/view/" + id!!
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int?): String {
        carRepository!!.deleteById(id)
        return "redirect:/car"
    }
}
