package com.example.citronix.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
public class Farm {
    @Id
    private UUID id;
    private String name;
    private String Location;
    private Integer area;
    private LocalDate creationDate;
    @OneToMany
    private List<Field> fields;

}
