package com.kivicms.test.models;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    /**
     * Гос номер
     */
    private String number;

    /**
     * Статус авто
     */
    private Integer status;

    public Car() {
    }

    public Car(Vendor vendor, Mark mark, String number, Integer status) {
        this.vendor = vendor;
        this.mark = mark;
        this.number = number;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getVendorName()
    {
        return this.vendor.getName();
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Mark getMark() {
        return mark;
    }

    public String getMarkName()
    {
        return this.mark.getName();
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
