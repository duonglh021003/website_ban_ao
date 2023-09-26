package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Color;
import com.example.demo.asm.service.ColorService;
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
@RequestMapping(value = "/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<Color> pageColor = colorService.getAll(pageable);
        model.addAttribute("listColor", pageColor);
        model.addAttribute("view", "/WEB-INF/views/color/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("color", new Color());
        model.addAttribute("view", "/WEB-INF/views/color/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("color") Color color, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/views/color/view-add.jsp");
            return "layout";
        }else {
            colorService.add(color);
        }

        return "redirect:/color/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("color", new Color());

        Color color = colorService.detail(Long.valueOf(id));
        model.addAttribute("color", color);

        model.addAttribute("view", "/WEB-INF/views/color/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("color") Color color,
                         @RequestParam("id") String id
    ) {

        colorService.update(color,Long.valueOf(id));
        return "redirect:/color/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("color", new Color());

        Color color = colorService.detail(Long.valueOf(id));
        model.addAttribute("color", color);

        model.addAttribute("view", "/WEB-INF/views/color/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        colorService.delete(Long.valueOf(id));
        return "redirect:/color/index";
    }

}
