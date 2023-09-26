package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Position;
import com.example.demo.asm.service.PositionService;
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
@RequestMapping(value = "/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<Position> pagePosition = positionService.getAll(pageable);
        model.addAttribute("listPosition", pagePosition);
        model.addAttribute("view", "/WEB-INF/views/position/index.jsp");
        return "layout";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("position", new Position());
        model.addAttribute("view", "/WEB-INF/views/position/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("position") Position position, Model model, BindingResult result) {
        if (result.hasErrors()) {

            model.addAttribute("view", "/WEB-INF/views/position/view-add.jsp");
            return "layout";
        } else {
            positionService.add(position);

        }
        model.addAttribute("view", "/WEB-INF/views/position/index.jsp");
        return "redirect:/position/index";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("position", new Position());

        Position position = positionService.detail(Long.valueOf(id));
        model.addAttribute("position", position);
        model.addAttribute("view", "/WEB-INF/views/position/view-update.jsp");

        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("position") Position position,
                         @RequestParam("id") String id
    ) {

        positionService.update(position,Long.valueOf(id));
        return "redirect:/position/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        positionService.delete(Long.valueOf(id));
        return "redirect:/position/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("position", new Position());

        Position position = positionService.detail(Long.valueOf(id));
        model.addAttribute("position", position);
        model.addAttribute("view", "/WEB-INF/views/position/detail.jsp");
        return "layout";
    }
}
