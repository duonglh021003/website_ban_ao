package com.example.demo.asm.service.Impl;

import com.example.demo.asm.entity.Shop;
import com.example.demo.asm.repository.ShopRepository;
import com.example.demo.asm.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Page<Shop> getAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    @Override
    public void add(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void update(Shop shop, Long id) {
        shopRepository.save(shop);
    }

    @Override
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Shop detail(Long id) {
        return shopRepository.getById(id);
    }


}
