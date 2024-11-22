package com.example.citronix.Service;

import com.example.citronix.DTO.SaleDTO;
import com.example.citronix.Entity.Sale;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleService {
    SaleDTO createSale(SaleDTO sale);

    Optional<SaleDTO> getSaleById(UUID id);

    List<SaleDTO> getAllSales();

    SaleDTO updateSale(UUID id, SaleDTO sale);

    void deleteSale(UUID id);
}
