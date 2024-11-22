package com.example.citronix.Service.Implementation;

import com.example.citronix.DTO.SaleDTO;
import com.example.citronix.Entity.Sale;
import com.example.citronix.Repository.SaleRepository;
import com.example.citronix.Service.SaleService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Data
public class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository;
    private ModelMapper SaleMapper;

    @Override
    public SaleDTO createSale(Sale sale) {
        return SaleMapper.map(saleRepository.save(sale), SaleDTO.class);
    }

    @Override
    public Optional<SaleDTO> getSaleById(UUID id) {
        return saleRepository.findById(id).map((element) -> SaleMapper.map(element, SaleDTO.class));
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream().map((element) -> SaleMapper.map(element, SaleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SaleDTO updateSale(UUID id, SaleDTO sale) {
        return saleRepository.findById(id).map(existingSale -> {
            existingSale.setDate(sale.getDate());
            existingSale.setTotalRevenue(sale.getTotalRevenue());
            existingSale.setClient(sale.getClient());
            return SaleMapper.map(saleRepository.save(existingSale), SaleDTO.class);
        }).orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    @Override
    public void deleteSale(UUID id) {
        saleRepository.deleteById(id);
    }
}
