package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Staff;
import com.example.demo.asm.repository.StaffRepository;
import com.example.demo.asm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;


    @Override
    public Page<Staff> getAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public void add(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void update(Staff staff, Long id) {
        staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff detail(Long id) {
        return staffRepository.getById(id);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
}
