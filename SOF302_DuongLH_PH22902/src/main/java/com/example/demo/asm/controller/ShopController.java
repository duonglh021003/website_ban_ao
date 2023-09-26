package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Shop;
import com.example.demo.asm.service.ShopService;
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
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Shop> pageShop = shopService.getAll(pageable);
        model.addAttribute("listShop", pageShop);
        model.addAttribute("view", "/WEB-INF/views/shop/index.jsp");
        return "layout";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("shop", new Shop());
        model.addAttribute("view", "/WEB-INF/views/shop/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("shop") Shop shop, Model model, BindingResult result) {
        if (result.hasErrors()) {

            model.addAttribute("view", "/WEB-INF/views/shop/view-add.jsp");
            return "layout";
        } else {
            shopService.add(shop);

        }
        return "redirect:/shop/index";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("shop", new Shop());

        Shop shop = shopService.detail(Long.valueOf(id));
        model.addAttribute("shop", shop);
        model.addAttribute("view", "/WEB-INF/views/shop/view-update.jsp");

        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("shop") Shop shop,
                         @RequestParam("id") String id
                         ) {

        shopService.update(shop,Long.valueOf(id));
        return "redirect:/shop/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        shopService.delete(Long.valueOf(id));
        return "redirect:/shop/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("shop", new Shop());

        Shop shop = shopService.detail(Long.valueOf(id));
        model.addAttribute("shop", shop);
        model.addAttribute("view", "/WEB-INF/views/shop/detail.jsp");
        return "layout";
    }

}
