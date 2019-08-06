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

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;

    /**
     * Гос номер
     */
    private String number;

    /**
     * Статус авто
     * 0 - свободно, 1 - в работе
     */
    private Integer status;

    public Car() {
    }

    public Car(String number) {
        this.number = number;
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

    public String getStatusName(){
        if (this.status == 0) {
            return "Свободно";
        }
        return "В работе";
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

    public Integer getVendorId() {
        if (this.vendor != null) {
            return this.vendor.getId();
        }
        return 0;
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

    public Integer getMarkId() {
        if (this.mark != null) {
            return this.mark.getId();
        }
        return 0;
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

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public String getRenterFio() {
        if (this.renter != null) {
            return this.renter.getFio();
        }
        return "Нет";
    }

    public String getFullCarName() {
        return this.vendor.getName() + " / " + this.mark.getName() + " / " + this.number;
    }
}
