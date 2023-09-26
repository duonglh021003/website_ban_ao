package com.example.demo.asm.service;

import com.example.demo.asm.entity.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProducerService {

    Page<Producer> getAll(Pageable pageable);

    void add(Producer producer);

    void update(Producer producer, Long id);

    void delete(Long id);

    Producer detail(Long id);

}
