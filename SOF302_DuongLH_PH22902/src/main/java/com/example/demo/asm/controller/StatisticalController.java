package com.example.demo.asm.controller;

import com.example.demo.asm.entity.DetailedInvoice;
import com.example.demo.asm.repository.DetailInvoiceReporytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/statistical")
public class StatisticalController {

    @Autowired
    private DetailInvoiceReporytory detailInvoiceReporytory;

    @GetMapping("/index")
    public String index(Model model) {


        int salesToday = countSalesByDate(LocalDate.now());
        int salesThisYear = countSalesByYear(LocalDate.now());

        model.addAttribute("listStatistical",new StatisticalController());
        System.err.printf("Trong năm nay đã bán được %d VNĐ \n", salesThisYear);
        System.err.printf("Hôm nay đã bán được %d VNĐ ", salesToday);
        model.addAttribute("view", "/WEB-INF/views/statistical/index.jsp");
        return "layout";

    }


    public int countSalesByDate(LocalDate date) {
        int salesCount = 0;
        for (DetailedInvoice sale : detailInvoiceReporytory.findAll()) {
            if (sale.getIdDetailedInvoice().getInvoice().getDateCreated().equals(date)) {
                salesCount += sale.getQuantity();
                salesCount *= sale.getUnitPrice();
                System.out.println("aaaaaaaaaaaaaaaa        "+detailInvoiceReporytory.findAll());
                System.out.println("bbbbbbbbbbbbbbbb        "+sale.getIdDetailedInvoice().getInvoice().getDateCreated());
                System.out.println("cccccccccccccccc        "+date);
                System.out.println("dddddddddddddddd        "+sale.getQuantity());
                System.out.println("eeeeeeeeeeeeeeee        "+sale.getUnitPrice());
            }
        }
        return salesCount;
    }

    public int countSalesByYear(LocalDate year) {
        int salesCount = 0;
        for (DetailedInvoice sale : detailInvoiceReporytory.findAll()) {
            if (sale.getIdDetailedInvoice().getInvoice().getDateCreated().getYear() == year.getYear()) {
                salesCount += sale.getQuantity();
                salesCount *= sale.getUnitPrice();
            }
        }
        return salesCount;
    }


}
