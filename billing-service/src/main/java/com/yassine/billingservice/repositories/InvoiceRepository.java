package com.yassine.billingservice.repositories;

import com.yassine.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
