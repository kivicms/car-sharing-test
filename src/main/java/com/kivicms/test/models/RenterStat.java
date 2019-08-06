package com.kivicms.test.models;

public class RenterStat {

    private Renter renter;

    private Long durationSeconds;

    private String durationString;

    public RenterStat(Renter renter, Long durationSeconds) {
        this.renter = renter;
        this.durationSeconds = durationSeconds;

        Long hours = durationSeconds / 3600;
        Long minutes = (durationSeconds % 3600) / 60;
        this.durationString = String.format("%d часов %02d минут", hours, minutes);
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
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
