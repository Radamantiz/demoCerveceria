package com.develop.beer2js.repository;

import com.develop.beer2js.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findBySitePointId(Long sitepoint_id);
}
