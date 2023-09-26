package com.example.demo.asm.service;


import com.example.demo.asm.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaffService {
    Page<Staff> getAll(Pageable pageable);

    void add(Staff staff);

    void update(Staff staff, Long id);

    void delete(Long id);

    Staff detail(Long id);

    List<Staff> findAll();
}
