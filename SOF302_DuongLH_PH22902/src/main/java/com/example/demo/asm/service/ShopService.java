package com.example.demo.asm.service;

import com.example.demo.asm.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopService {

    Page<Shop> getAll(Pageable pageable);

    void add(Shop shop);

    void update(Shop shop,Long id);

    void delete(Long id);

    Shop detail(Long id);
}
