package com.kivicms.test.models;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    // private Integer vendorId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Mark() {
    }

    /*public Mark(Integer vendorId, String name) {
        this.vendorId = vendorId;
        this.name = name;
    }*/

    public Mark(Vendor vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public String getVendorName()
    {
        return this.vendor.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
