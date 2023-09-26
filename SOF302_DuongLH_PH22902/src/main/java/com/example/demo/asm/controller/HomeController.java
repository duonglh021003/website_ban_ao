package com.example.demo.asm.controller;

import com.example.demo.asm.entity.ProductDetails;
import com.example.demo.asm.repository.ColorRepository;
import com.example.demo.asm.repository.ProducerRepository;
import com.example.demo.asm.repository.ProductDetailsRepository;
import com.example.demo.asm.repository.ProductLineRepository;
import com.example.demo.asm.repository.ProductRepositoty;
import com.example.demo.asm.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private ProductRepositoty productRepositoty;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ProductLineRepository productLineRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("productDetails", new ProductDetails());
        model.addAttribute("listProduct", productRepositoty.findAll());
        model.addAttribute("listProducer", producerRepository.findAll());
        model.addAttribute("listColor", colorRepository.findAll());
        model.addAttribute("listProductLine", productLineRepository.findAll());

        model.addAttribute("listProductDetails", productDetailsRepository.findAll());
        model.addAttribute("view", "/WEB-INF/views/home/index.jsp");
        return "layout";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name,Model model){
        model.addAttribute("productDetails", new ProductDetails());
        model.addAttribute("listProductDetails", productDetailsService.getByName(name));
        model.addAttribute("view", "/WEB-INF/views/home/index.jsp");
        return "layout";
    }


}
