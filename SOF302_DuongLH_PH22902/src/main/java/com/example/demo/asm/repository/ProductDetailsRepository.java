package com.example.demo.asm.repository;

import com.example.demo.asm.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
    @Query(value = "select hdct from product_details hdct where hdct.id=?1", nativeQuery = true)
    List<ProductDetails> findByHoaDonId(Long id);
}
