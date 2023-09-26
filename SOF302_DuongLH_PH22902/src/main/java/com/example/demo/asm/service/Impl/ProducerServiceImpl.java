package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Producer;
import com.example.demo.asm.repository.ProducerRepository;
import com.example.demo.asm.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public Page<Producer> getAll(Pageable pageable) {
        return producerRepository.findAll(pageable);
    }

    @Override
    public void add(Producer producer) {
        producerRepository.save(producer);
    }

    @Override
    public void update(Producer producer, Long id) {
        producerRepository.save(producer);
    }

    @Override
    public void delete(Long id) {
        producerRepository.deleteById(id);
    }

    @Override
    public Producer detail(Long id) {
        return producerRepository.getById(id);
    }
}
