package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Product;
import com.example.demo.asm.repository.ProductRepositoty;
import com.example.demo.asm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoty productRepositoty;


    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepositoty.findAll(pageable);
    }

    @Override
    public void add(Product product) {
        productRepositoty.save(product);
    }

    @Override
    public void update(Product product, Long id) {
        productRepositoty.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepositoty.deleteById(id);
    }

    @Override
    public Product detail(Long id) {
        return productRepositoty.getById(id);
    }
}
