package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Client;
import com.example.demo.asm.repository.ClientRepository;
import com.example.demo.asm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public void add(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void update(Client client, Long id) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client detail(Long id) {
        return clientRepository.getById(id);
    }
}
