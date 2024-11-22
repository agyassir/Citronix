package com.example.citronix.Service;

import com.example.citronix.Entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    Client createClient(Client client);

    Optional<Client> getClientById(UUID id);

    List<Client> getAllClients();

    Client updateClient(UUID id, Client client);

    void deleteClient(UUID id);
}
