package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.ProductLine;
import com.example.demo.asm.repository.ProductLineRepository;
import com.example.demo.asm.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;

    @Override
    public Page<ProductLine> getAll(Pageable pageable) {
        return productLineRepository.findAll(pageable);
    }

    @Override
    public void add(ProductLine productLine) {
        productLineRepository.save(productLine);
    }

    @Override
    public void update(ProductLine productLine, Long id) {
        productLineRepository.save(productLine);
    }

    @Override
    public void delete(Long id) {
        productLineRepository.deleteById(id);
    }

    @Override
    public ProductLine detail(Long id) {
        return productLineRepository.getById(id);
    }
}
