package com.example.rhealth_hms.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice extends IdEntity {

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItem> invoiceItems;

    @Column(nullable = false)
    private double totalAmount;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private User staff;

    @ManyToOne(optional = false)
    private Session session;
}