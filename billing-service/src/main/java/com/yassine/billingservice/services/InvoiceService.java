package com.yassine.billingservice.services;

import com.yassine.billingservice.clients.CustomerServiceClient;
import com.yassine.billingservice.clients.InventoryServiceClient;
import com.yassine.billingservice.dtos.Customer;
import com.yassine.billingservice.dtos.Product;
import com.yassine.billingservice.entities.Invoice;
import com.yassine.billingservice.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pc
 **/
@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerServiceClient customerServiceClient;
    private final InventoryServiceClient inventoryServiceClient;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public Invoice createInvoice(Invoice invoice) {

        Customer customer =
                customerServiceClient.getCustomerById(invoice.getCustomerId());

        Product product =
                inventoryServiceClient.getProductById(invoice.getProductId());

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        invoice.setDate(LocalDateTime.now());

        return invoiceRepository.save(invoice);
    }


}
