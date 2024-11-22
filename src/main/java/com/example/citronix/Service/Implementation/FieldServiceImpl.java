package com.example.citronix.Service.Implementation;

import com.example.citronix.Entity.Field;
import com.example.citronix.Repository.FieldRepository;
import com.example.citronix.Service.FieldService;
import com.example.citronix.Util.Checker.filedCheck;
import com.example.citronix.Util.Validation.FieldValidation;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class FieldServiceImpl implements FieldService {
    private FieldRepository fieldRepository;
    private filedCheck fieldCheck;
    @Override
    public Field createField(Field field) {
        if (fieldCheck.check(field)){
            return fieldRepository.save(field);
        }
        return null;
    }

    @Override
    public Optional<Field> getFieldById(UUID id) {
        return fieldRepository.findById(id);
    }

    @Override
    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public Field updateField(UUID id, Field field) {
        return fieldRepository.findById(id).map(existingField -> {
            existingField.setArea(field.getArea());
            existingField.setFarm(field.getFarm());
            return fieldRepository.save(existingField);
        }).orElseThrow(() -> new RuntimeException("Field not found"));
    }

    @Override
    public void deleteField(UUID id) {
        fieldRepository.deleteById(id);
    }
}
