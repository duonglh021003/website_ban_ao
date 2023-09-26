package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Client;
import com.example.demo.asm.entity.DetailedInvoice;
import com.example.demo.asm.entity.Invoice;
import com.example.demo.asm.entity.ProductDetails;
import com.example.demo.asm.repository.ClientRepository;
import com.example.demo.asm.repository.DetailInvoiceReporytory;
import com.example.demo.asm.repository.ProductDetailsRepository;
import com.example.demo.asm.repository.ProductRepositoty;
import com.example.demo.asm.repository.StaffRepository;
import com.example.demo.asm.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private ProductRepositoty productRepositoty;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private DetailInvoiceReporytory detailInvoiceReporytory;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("/index")
    public String index(@RequestParam("id") String id, Model model){
        model.addAttribute("productDetails", new ProductDetails());
        model.addAttribute("client", new Client());
        model.addAttribute("detailInvoice" ,new DetailedInvoice());

        ProductDetails productDetails = productDetailsRepository.getById(Long.valueOf(id));
        model.addAttribute("productDetails", productDetails);


        model.addAttribute("listProduct", productRepositoty.findAll());
        model.addAttribute("listDetailInvoice", detailInvoiceReporytory.findAll());

          model.addAttribute("view", "/WEB-INF/views/invoice/index.jsp");
        return "layout";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){

        model.addAttribute("invoice", new Invoice());

        model.addAttribute("idDetailedInvoice", detailInvoiceReporytory.findAll());
        model.addAttribute("listClient", clientRepository.findAll());
        model.addAttribute("listStaff", staffRepository.findAll());

        model.addAttribute("view", "/WEB-INF/views/invoice/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("invoice") Invoice invoice,Model model){

        invoiceService.add(invoice);
        return "redirect:/detail-invoice/view-add";
    }
}
