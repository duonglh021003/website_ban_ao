package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Producer;
import com.example.demo.asm.service.ProducerService;
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
@RequestMapping(value = "/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<Producer> pageProducer = producerService.getAll(pageable);
        model.addAttribute("listProducer", pageProducer);
        model.addAttribute("view", "/WEB-INF/views/producer/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("producer", new Producer());
        model.addAttribute("view", "/WEB-INF/views/producer/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("producer") Producer producer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/views/producer/view-add.jsp");
            return "layout";
        }else {
            producerService.add(producer);
        }

        return "redirect:/producer/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("producer", new Producer());

        Producer producer = producerService.detail(Long.valueOf(id));
        model.addAttribute("producer", producer);

        model.addAttribute("view", "/WEB-INF/views/producer/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("producer") Producer producer,
                         @RequestParam("id") String id
    ) {

        producerService.update(producer,Long.valueOf(id));
        return "redirect:/producer/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("producer", new Producer());

        Producer producer = producerService.detail(Long.valueOf(id));
        model.addAttribute("producer", producer);

        model.addAttribute("view", "/WEB-INF/views/producer/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        producerService.delete(Long.valueOf(id));
        return "redirect:/producer/index";
    }
}
