package com.example.citronix.Service.Implementation;

import com.example.citronix.Entity.Client;
import com.example.citronix.Repository.ClientRepository;
import com.example.citronix.Service.ClientService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(UUID id, Client client) {
        return clientRepository.findById(id).map(existingClient -> {
            existingClient.setName(client.getName());
            existingClient.setEmail(client.getEmail());
            existingClient.setPhone(client.getPhone());
            return clientRepository.save(existingClient);
        }).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }
}
