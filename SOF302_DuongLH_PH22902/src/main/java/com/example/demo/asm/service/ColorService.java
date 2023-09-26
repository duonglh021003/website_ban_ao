package com.example.demo.asm.service;

import com.example.demo.asm.entity.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ColorService {

    Page<Color> getAll(Pageable pageable);

    void add(Color color);

    void update(Color color, Long id);

    void delete(Long id);

    Color detail(Long id);


}
