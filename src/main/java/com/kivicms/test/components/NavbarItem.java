package com.kivicms.test.components;

import java.util.ArrayList;

public class NavbarItem {

    private String url;
    private String icon;
    private String label;
    private ArrayList<NavbarItem> items;

    private boolean isActive = false;

    public NavbarItem(String url, String label, String icon, ArrayList<NavbarItem> items) {
        this.url = url;
        this.icon = icon;
        this.label = label;
        this.items = items;
    }

    public NavbarItem(String url, String label) {
        this.url = url;
        this.label = label;
        this.icon = "fa-circle-o";
        this.items = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<NavbarItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<NavbarItem> items) {
        this.items = items;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
