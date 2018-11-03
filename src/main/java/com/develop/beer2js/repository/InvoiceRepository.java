package com.develop.beer2js.repository;

import com.develop.beer2js.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
   List<Invoice> findBysalepoint_id(Long salepoint_id);
}
