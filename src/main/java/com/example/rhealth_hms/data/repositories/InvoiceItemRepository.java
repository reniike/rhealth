package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
