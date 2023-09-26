package com.example.demo.asm.service;

import com.example.demo.asm.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAll();

    void add(Invoice invoice);

    void delete(Long id);
}
