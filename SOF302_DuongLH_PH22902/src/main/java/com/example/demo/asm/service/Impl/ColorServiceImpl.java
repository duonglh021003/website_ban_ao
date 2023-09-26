package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Color;
import com.example.demo.asm.repository.ColorRepository;
import com.example.demo.asm.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Page<Color> getAll(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }

    @Override
    public void add(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void update(Color color, Long id) {
        colorRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public Color detail(Long id) {
        return colorRepository.getById(id);
    }
}
