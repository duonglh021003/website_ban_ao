package com.example.demo.asm.controller;


import com.example.demo.asm.entity.ProductLine;
import com.example.demo.asm.service.ProductLineService;

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
@RequestMapping(value = "/product-line")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<ProductLine> pageProductLine = productLineService.getAll(pageable);
        model.addAttribute("listProductLine", pageProductLine);
        model.addAttribute("view", "/WEB-INF/views/product_line/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("productLine", new ProductLine());
        model.addAttribute("view", "/WEB-INF/views/product_line/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("productLine") ProductLine productLine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/views/product_line/view-add.jsp");
            return "layout";
        }else {
            productLineService.add(productLine);
        }

        return "redirect:/product-line/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("productLine", new ProductLine());

        ProductLine productLine = productLineService.detail(Long.valueOf(id));
        model.addAttribute("productLine", productLine);

        model.addAttribute("view", "/WEB-INF/views/product_line/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("productLine") ProductLine productLine,
                         @RequestParam("id") String id
    ) {

        productLineService.update(productLine,Long.valueOf(id));
        return "redirect:/product-line/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("productLine", new ProductLine());

        ProductLine productLine = productLineService.detail(Long.valueOf(id));
        model.addAttribute("productLine", productLine);

        model.addAttribute("view", "/WEB-INF/views/product_line/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        productLineService.delete(Long.valueOf(id));
        return "redirect:/product-line/index";
    }
}
