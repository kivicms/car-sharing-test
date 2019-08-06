package com.kivicms.test.models;

public class CarStat {

    private Car car;

    private Long durationSeconds;

    private String durationString;

    public CarStat(Car car, Long durationSeconds) {
        this.car = car;
        this.durationSeconds = durationSeconds;

        Long hours = durationSeconds / 3600;
        Long minutes = (durationSeconds % 3600) / 60;
        this.durationString = String.format("%d часов %02d минут", hours, minutes);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public String getDurationString() {
        return durationString;
    }

    public void setDurationString(String durationString) {
        this.durationString = durationString;
    }
}
