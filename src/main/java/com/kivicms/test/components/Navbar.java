package com.kivicms.test.components;


import java.util.ArrayList;

public class Navbar  {

    private ArrayList<NavbarItem> items;

    public Navbar() {
        ArrayList<NavbarItem> ops = new ArrayList<>();
        ops.add(new NavbarItem("/operation", "Операции"));
        ops.add(new NavbarItem("/operation/issue", "Выдать ТС"));
        this.items.add(new NavbarItem("#", "Операции с ТС", "fa-dashboard", ops));

        ArrayList<NavbarItem> stats = new ArrayList<>();
        stats.add(new NavbarItem("/statistics/car", "По ТС"));
        stats.add(new NavbarItem("/statistics/renter", "По арендаторам"));
        this.items.add(new NavbarItem("#", "Статистика", "fa-dashboard", stats));

        ArrayList<NavbarItem> cats = new ArrayList<>();
        cats.add(new NavbarItem("/vendor", "Производители"));
        cats.add(new NavbarItem("/mark", "Модели"));
        cats.add(new NavbarItem("/car", "Автомобили"));
        cats.add(new NavbarItem("/renter", "Арендаторы"));
        this.items.add(new NavbarItem("#", "Справочники", "fa-table", cats));

        this.normalizeItems();
    }

    private void normalizeItems() {

    }

    public ArrayList<NavbarItem> getItems() {
        return items;
    }

}
