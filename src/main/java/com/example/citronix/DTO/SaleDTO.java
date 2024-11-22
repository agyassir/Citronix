package com.example.citronix.DTO;

import com.example.citronix.Entity.Client;
import com.example.citronix.Entity.Harvest;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class SaleDTO {
    private UUID id;
    private LocalDate date;
    private Double unitPrice;
    private Client client;
    private Double totalRevenue;
    private Harvest harvest;
}
