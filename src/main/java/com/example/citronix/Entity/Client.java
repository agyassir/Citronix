package com.example.citronix.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Client {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sale> sales;

}
