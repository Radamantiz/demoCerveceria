package com.develop.beer2js.model;

import javax.validation.constraints.NotNull;

public class VarietyDTO extends AuditModel {
    @NotNull
    private String name;
    @NotNull
    private boolean active;
    @NotNull
    private double  pint_price;
    @NotNull
    private double  half_pint_price;
    @NotNull
    private double bottle_price;
    @NotNull
    private double ibu;
    @NotNull
    private double alcohol_percentage;
    @NotNull
    private long provider_id;
    @NotNull
    private long color_id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPint_price() {
        return pint_price;
    }

    public void setPint_price(double pint_price) {
        this.pint_price = pint_price;
    }

    public double getHalf_pint_price() {
        return half_pint_price;
    }

    public void setHalf_pint_price(double half_pint_price) {
        this.half_pint_price = half_pint_price;
    }

    public double getBottle_price() {
        return bottle_price;
    }

    public void setBottle_price(double bottle_price) {
        this.bottle_price = bottle_price;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public double getAlcohol_percentage() {
        return alcohol_percentage;
    }

    public void setAlcohol_percentage(double alcohol_percentage) {
        this.alcohol_percentage = alcohol_percentage;
    }

    public long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(long provider_id) {
        this.provider_id = provider_id;
    }

    public long getColor_id() {
        return color_id;
    }

    public void setColor_id(long color_id) {
        this.color_id = color_id;
    }
}


