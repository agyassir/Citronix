package com.example.citronix.Service.Implementation;

import com.example.citronix.DTO.FarmDto;
import com.example.citronix.Entity.Farm;
import com.example.citronix.Repository.FarmRepository;
import com.example.citronix.Service.FarmService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Data
public class FarmServiceImpl implements FarmService {
    private FarmRepository farmRepository;
    private ModelMapper FarmMapper;

    @Override
    public Farm createFarm(FarmDto farmdto) {
        Farm farm=FarmMapper.map(farmdto,Farm.class);
        return farmRepository.save(farm);
    }

    @Override
    public Optional<FarmDto> getFarmById(UUID id) {
        return farmRepository.findById(id).map((element) -> FarmMapper.map(element, FarmDto.class));
    }

    @Override
    public List<FarmDto> getAllFarms() {
        return farmRepository.findAll().stream().map((element) -> FarmMapper.map(element, FarmDto.class)).collect(Collectors.toList());
    }

    @Override
    public FarmDto updateFarm(UUID id, FarmDto farm) {
        return farmRepository.findById(id).map(existingFarm -> {
            if (farm.getName() != null) existingFarm.setName(farm.getName());
            if (farm.getLocation() != null) existingFarm.setLocation(farm.getLocation());
            if (farm.getArea() != null) existingFarm.setArea(farm.getArea());
            return FarmMapper.map(farmRepository.save(existingFarm), FarmDto.class);
        }).orElseThrow(() -> new RuntimeException("Farm not found"));
    }

    @Override
    public void deleteFarm(UUID id) {
        farmRepository.deleteById(id);
    }
}
