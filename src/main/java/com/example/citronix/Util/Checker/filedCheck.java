package com.example.citronix.Util.Checker;

import com.example.citronix.Entity.Field;

public class filedCheck {
    public boolean check(Field field) {
        if (field.getArea() <= 1000) {
            throw new RuntimeException("The area of the field must be at least 0.1 hectares (1000 m²).");
        }

        if (field.getArea() >= (field.getFarm().getArea() * 0.5)) {
            throw new RuntimeException("The area of the field exceeds 50% of the total farm area.");
        }

        if (field.getFarm().getFields().size() >= 10) {
            throw new RuntimeException("The farm cannot have more than 10 fields.");
        }

        Double leftArea = field.getFarm().getArea()
                - field.getFarm().getFields().stream()
                .map(Field::getArea)
                .reduce(0.0, Double::sum);

        if (field.getArea() > leftArea) {
            throw new RuntimeException("The field area exceeds the remaining area available in the farm.");
        }

        return true;
    }
}
