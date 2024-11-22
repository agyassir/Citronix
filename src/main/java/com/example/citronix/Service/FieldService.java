package com.example.citronix.Service;

import com.example.citronix.Entity.Field;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FieldService {
    Field createField(Field field);

    Optional<Field> getFieldById(UUID id);

    List<Field> getAllFields();

    Field updateField(UUID id, Field field);

    void deleteField(UUID id);
}
