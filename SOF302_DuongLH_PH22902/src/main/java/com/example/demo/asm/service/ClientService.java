package com.example.demo.asm.service;


import com.example.demo.asm.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<Client> getAll(Pageable pageable);

    void add(Client client);

    void update(Client client, Long id);

    void delete(Long id);

    Client detail(Long id);
}
