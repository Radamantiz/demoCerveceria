package com.develop.beer2js.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "variety")
public class Variety extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Provider provider;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "color_id", updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Color color;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}


