package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.ProductDetails;
import com.example.demo.asm.repository.ProductDetailsRepository;
import com.example.demo.asm.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;
    @Override
    public Page<ProductDetails> getAll(Pageable pageable) {
        return productDetailsRepository.findAll(pageable);
    }

    @Override
    public void add(ProductDetails productDetails) {
        productDetailsRepository.save(productDetails);
    }

    @Override
    public void update(ProductDetails productDetails, Long id) {
        productDetailsRepository.save(productDetails);
    }

    @Override
    public void delete(Long id) {
        productDetailsRepository.deleteById(id);
    }

    @Override
    public ProductDetails detail(Long id) {
        return productDetailsRepository.getById(id);
    }

    @Override
    public List<ProductDetails> getByName(String name) {
        List<ProductDetails> list = new ArrayList<>();
        for(ProductDetails productDetails : productDetailsRepository.findAll()){
            if(productDetails.getProduct().getName().equalsIgnoreCase(name)){
                list.add(productDetails);
            }
        }
        return list;
    }

}
