package com.example.demo.asm.service;

import com.example.demo.asm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getAll(Pageable pageable);

    void add(Product product);

    void update(Product product, Long id);

    void delete(Long id);

    Product detail(Long id);

}
