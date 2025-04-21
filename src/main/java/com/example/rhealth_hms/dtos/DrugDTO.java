package com.example.rhealth_hms.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrugDTO {

    private Long id;

    private String name;

    private int quantity;

    private double amount;

    private String description;

}
