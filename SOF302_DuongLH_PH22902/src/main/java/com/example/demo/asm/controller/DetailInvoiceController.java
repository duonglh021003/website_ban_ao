package com.example.demo.asm.controller;

import com.example.demo.asm.entity.DetailedInvoice;
import com.example.demo.asm.entity.IdDetailedInvoice;
import com.example.demo.asm.entity.Invoice;
import com.example.demo.asm.entity.ProductDetails;
import com.example.demo.asm.repository.ClientRepository;
import com.example.demo.asm.repository.DetailInvoiceReporytory;
import com.example.demo.asm.repository.InvoiceRepository;
import com.example.demo.asm.repository.ProductDetailsRepository;
import com.example.demo.asm.repository.StaffRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/detail-invoice")
public class DetailInvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private DetailInvoiceReporytory detailInvoiceReporytory;


    @GetMapping("/index")
    public String index(Model model, @RequestParam("id") Long id){

        model.addAttribute("listDetailInvoice",detailInvoiceReporytory.findAll());
        List<ProductDetails> productDetails = productDetailsRepository.findByHoaDonId(id);
        model.addAttribute("detailInvoice",productDetails);
        model.addAttribute("view", "/WEB-INF/views/detail_invoice/index.jsp");
        return "layout";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){

        model.addAttribute("detailInvoice", new DetailedInvoice());

        model.addAttribute("listInvoice", invoiceRepository.findAll());
        model.addAttribute("listProductDetails", productDetailsRepository.findAll());

        model.addAttribute("view", "/WEB-INF/views/detail_invoice/view-add.jsp");
        return "layout";

    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("detailInvoice") DetailedInvoice detailedInvoice, Model model){
        detailInvoiceReporytory.save(detailedInvoice);
        return "redirect:/detail-invoice/index";
    }

}
