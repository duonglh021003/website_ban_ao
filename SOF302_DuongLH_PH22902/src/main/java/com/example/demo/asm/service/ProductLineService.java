package com.example.demo.asm.service;

import com.example.demo.asm.entity.ProductLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductLineService {

    Page<ProductLine> getAll(Pageable pageable);

    void add(ProductLine productLine);

    void update(ProductLine productLine, Long id);

    void delete(Long id);

    ProductLine detail(Long id);

}
