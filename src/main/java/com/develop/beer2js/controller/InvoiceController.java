package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Invoice;
import com.develop.beer2js.model.InvoiceDTO;
import com.develop.beer2js.repository.InvoiceRepository;
import com.develop.beer2js.repository.SalePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private SalePointRepository salePointRepository;
    @GetMapping("/invoices")
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoices/{invoice_id}")
    public Invoice getInvoiceById(@PathVariable("invoice_id") Long invoice_id){
        return invoiceRepository.findById(invoice_id)
                .orElseThrow(()->new ResourceNotFoundException("Invoice","invoice_id",invoice_id));
    }

    @PostMapping("/invoices")
    public Invoice addInvoice(@Valid @RequestBody InvoiceDTO invoiceInformation){
        return salePointRepository.findById(invoiceInformation.getSalepoint_id()).map(salePoint -> {
            Invoice invoice = new Invoice();
            invoice.setBill_number(invoiceInformation.getBill_number());
            invoice.setIva_21(invoiceInformation.getIva_21());
            invoice.setIva_105(invoiceInformation.getIva_105());
            invoice.setIva_excento(invoiceInformation.getIva_excento());
            invoice.setIva_grabado(invoiceInformation.getIva_grabado());
            invoice.setIva_nograbado(invoiceInformation.getIva_nograbado());
            invoice.setSalepoint(salePoint);
            invoice.setSubtotal(invoiceInformation.getSubtotal());
            invoice.setTotal(invoiceInformation.getTotal());
            return invoiceRepository.save(invoice);
        }).orElseThrow(()-> new ResourceNotFoundException("salePoint", "salepoint_id",invoiceInformation.getSalepoint_id()));
    }
}
