package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
}
