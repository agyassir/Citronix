package com.example.citronix.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Sale {
    @Id
    private UUID id;
    private LocalDate date;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private Double totalRevenue;
    @ManyToOne
    @JoinColumn(name = "harvest_id", nullable = false)
    private Harvest harvest;
}
