package com.example.demo.asm.service;


import com.example.demo.asm.entity.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDetailsService {

    Page<ProductDetails> getAll(Pageable pageable);

    void add(ProductDetails productDetails);

    void update(ProductDetails productDetails, Long id);

    void delete(Long id);

    ProductDetails detail(Long id);

    List<ProductDetails> getByName(String name);

}
