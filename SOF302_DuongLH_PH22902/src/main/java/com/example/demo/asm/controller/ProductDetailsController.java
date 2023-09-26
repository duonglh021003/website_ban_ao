package com.example.demo.asm.controller;

import com.example.demo.asm.entity.ProductDetails;
import com.example.demo.asm.entity.Staff;
import com.example.demo.asm.repository.ColorRepository;
import com.example.demo.asm.repository.ProducerRepository;
import com.example.demo.asm.repository.ProductLineRepository;
import com.example.demo.asm.repository.ProductRepositoty;
import com.example.demo.asm.service.ProductDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/product-details")
public class ProductDetailsController {

    @Autowired
    private ProductRepositoty productRepositoty;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ProductLineRepository productLineRepository;

    @Autowired
    private ProductDetailsService productDetailsService;


    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<ProductDetails> pageProductDetails = productDetailsService.getAll(pageable);
        model.addAttribute("listProductDetails", pageProductDetails);
        model.addAttribute("view", "/WEB-INF/views/product_details/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("productDetails", new ProductDetails());
        model.addAttribute("listProduct", productRepositoty.findAll());
        model.addAttribute("listProducer", producerRepository.findAll());
        model.addAttribute("listColor", colorRepository.findAll());
        model.addAttribute("listProductLine", productLineRepository.findAll());
        model.addAttribute("view", "/WEB-INF/views/product_details/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("productDetails") ProductDetails productDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listProduct", productRepositoty.findAll());
            model.addAttribute("listProducer", producerRepository.findAll());
            model.addAttribute("listColor", colorRepository.findAll());
            model.addAttribute("listProductLine", productLineRepository.findAll());
            model.addAttribute("view", "/WEB-INF/views/product_details/view-add.jsp");
            return "layout";
        } else {
            productDetailsService.add(productDetails);
        }

        return "redirect:/product-details/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("productDetails", new ProductDetails());

        ProductDetails productDetails = productDetailsService.detail(Long.valueOf(id));
        model.addAttribute("productDetails", productDetails);

        model.addAttribute("listProduct", productRepositoty.findAll());
        model.addAttribute("listProducer", producerRepository.findAll());
        model.addAttribute("listColor", colorRepository.findAll());
        model.addAttribute("listProductLine", productLineRepository.findAll());
        model.addAttribute("view", "/WEB-INF/views/product_details/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("productDetails") ProductDetails productDetails,
                         @RequestParam("id") String id
    ) {

        productDetailsService.update(productDetails,Long.valueOf(id));
        return "redirect:/product-details/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){

        model.addAttribute("productDetails", new ProductDetails());

        ProductDetails productDetails = productDetailsService.detail(Long.valueOf(id));
        model.addAttribute("productDetails", productDetails);

        model.addAttribute("listProduct", productRepositoty.findAll());
        model.addAttribute("listProducer", producerRepository.findAll());
        model.addAttribute("listColor", colorRepository.findAll());
        model.addAttribute("listProductLine", productLineRepository.findAll());

        model.addAttribute("view", "/WEB-INF/views/product_details/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        productDetailsService.delete(Long.valueOf(id));
        return "redirect:/product-details/index";
    }


}
