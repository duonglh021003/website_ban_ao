package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Product;
import com.example.demo.asm.entity.Staff;
import com.example.demo.asm.service.ProductService;
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
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<Product> pageProduct = productService.getAll(pageable);
        model.addAttribute("listProduct", pageProduct);
        model.addAttribute("view", "/WEB-INF/views/product/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("view", "/WEB-INF/views/product/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/views/product/view-add.jsp");
            return "layout";
        }else {
            productService.add(product);
        }

        return "redirect:/product/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("product", new Product());

        Product product = productService.detail(Long.valueOf(id));
        model.addAttribute("product", product);

        model.addAttribute("view", "/WEB-INF/views/product/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product,
                         @RequestParam("id") String id
    ) {

        productService.update(product,Long.valueOf(id));
        return "redirect:/product/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("product", new Product());

        Product product = productService.detail(Long.valueOf(id));
        model.addAttribute("product", product);

        model.addAttribute("view", "/WEB-INF/views/product/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/product/index";
    }
    
}
