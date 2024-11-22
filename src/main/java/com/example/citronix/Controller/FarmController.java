package com.example.citronix.Controller;

import com.example.citronix.DTO.FarmDto;
import com.example.citronix.Entity.Enums.Role;
import com.example.citronix.Service.FarmService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/farm")
@Data
@AllArgsConstructor
public class FarmController {
    private FarmService farmService;
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody FarmDto request){
            farmService.createFarm(request);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestBody Role role){
        List<FarmDto>farms= farmService.getAllFarms();
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
