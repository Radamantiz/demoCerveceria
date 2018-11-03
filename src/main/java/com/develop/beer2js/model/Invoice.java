package com.develop.beer2js.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long bill_number;
    @NotNull
    private double iva_grabado;
    @NotNull
    private double iva_nograbado;
    @NotNull
    private double iva_excento;
    @NotNull
    private double subtotal;
    @NotNull
    private double total;
    @NotNull
    private double iva_21;
    @NotNull
    private double iva_105;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salepoint_id", updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private SalePoint salepoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBill_number() {
        return bill_number;
    }

    public void setBill_number(Long bill_number) {
        this.bill_number = bill_number;
    }

    public SalePoint getSalepoint() {
        return salepoint;
    }

    public void setSalepoint(SalePoint salepoint) {
        this.salepoint = salepoint;
    }

    public double getIva_grabado() {
        return iva_grabado;
    }

    public void setIva_grabado(double iva_grabado) {
        this.iva_grabado = iva_grabado;
    }

    public double getIva_nograbado() {
        return iva_nograbado;
    }

    public void setIva_nograbado(double iva_nograbado) {
        this.iva_nograbado = iva_nograbado;
    }

    public double getIva_excento() {
        return iva_excento;
    }

    public void setIva_excento(double iva_excento) {
        this.iva_excento = iva_excento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva_21() {
        return iva_21;
    }

    public void setIva_21(double iva_21) {
        this.iva_21 = iva_21;
    }

    public double getIva_105() {
        return iva_105;
    }

    public void setIva_105(double iva_105) {
        this.iva_105 = iva_105;
    }
}

