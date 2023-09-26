package com.example.demo.asm.service;


import com.example.demo.asm.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface PositionService {

    Page<Position> getAll(Pageable pageable);

    void add(Position position);

    void update(Position position,Long id);

    void delete(Long id);

    Position detail(Long id);

}
