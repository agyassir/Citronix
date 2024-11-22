package com.example.citronix.Controller;

import com.example.citronix.DTO.FarmDto;
import com.example.citronix.Entity.Enums.Role;
import com.example.citronix.Service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class SaleController {
    private SaleService saleService;
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody SaleDto request){
        saleService.createSale(request);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestBody Role role){
        List<FarmDto> farms= farmService.getAllFarms();
        return ResponseEntity.ok(farms);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id){
        return ResponseEntity.ok(farmService.getFarmById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,@RequestBody FarmDto request){
        FarmDto updatedFarm = farmService.updateFarm(id, request);
        return ResponseEntity.ok(updatedFarm);
    }
}
