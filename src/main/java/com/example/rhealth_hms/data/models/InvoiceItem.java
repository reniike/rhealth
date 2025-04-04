package com.example.rhealth_hms.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice_items")
public class InvoiceItem extends IdEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(optional = false)
    private Invoice invoice;

    @Column(nullable = false)
    private double unitAmount;

    @Column(nullable = false)
    private double totalAmount;
}