package com.develop.beer2js.model;

import javax.validation.constraints.NotNull;

public class BarrelDTO extends AuditModel {
    @NotNull
    private boolean tapped;
    @NotNull
    private double charge;
    @NotNull
    private Integer capacity;
    @NotNull
    private Long variety_id;

    public double getCharge() {
        return charge;
    }
    public void setCharge(double charge) {
        this.charge = charge;
    }
    public Long getVariety_id() {
        return variety_id;
    }
    public void setVariety_id(Long variety_id) {
        this.variety_id = variety_id;
    }
    public boolean isTapped() {
        return tapped;
    }
    public void setTapped(boolean tapped) {
        this.tapped = tapped;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}


