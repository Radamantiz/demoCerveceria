package com.develop.beer2js.model;

import javax.validation.constraints.NotNull;

public class InvoiceDTO {
    @NotNull
    private Long bill_number;
    @NotNull
    private Long salepoint_id;
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

    public Long getBill_number() {
        return bill_number;
    }

    public void setBill_number(Long bill_number) {
        this.bill_number = bill_number;
    }

    public Long getSalepoint_id() {
        return salepoint_id;
    }

    public void setSalepoint_id(Long salepoint_id) {
        this.salepoint_id = salepoint_id;
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
