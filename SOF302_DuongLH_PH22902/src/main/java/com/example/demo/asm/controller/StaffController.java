package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Shop;
import com.example.demo.asm.entity.Staff;
import com.example.demo.asm.repository.PositionRepository;
import com.example.demo.asm.repository.ShopRepository;
import com.example.demo.asm.service.StaffService;
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
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private StaffService staffService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<Staff> pageStaff = staffService.getAll(pageable);
        model.addAttribute("listStaff", pageStaff);
        model.addAttribute("view", "/WEB-INF/views/staff/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("listShop", shopRepository.findAll());
        model.addAttribute("listPosition", positionRepository.findAll());
        model.addAttribute("view", "/WEB-INF/views/staff/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("staff") Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listShop", shopRepository.findAll());
            model.addAttribute("listPosition", positionRepository.findAll());
            model.addAttribute("view", "/WEB-INF/views/staff/view-add.jsp");
            return "layout";
        }else {
            staffService.add(staff);
        }

        return "redirect:/staff/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("staff", new Staff());

        Staff staff = staffService.detail(Long.valueOf(id));
        model.addAttribute("staff", staff);



        model.addAttribute("listShop", shopRepository.findAll());
        model.addAttribute("listPosition", positionRepository.findAll());


        model.addAttribute("view", "/WEB-INF/views/staff/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("staff") Staff staff,
                         @RequestParam("id") String id
    ) {

        staffService.update(staff,Long.valueOf(id));
        return "redirect:/staff/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("staff", new Staff());

        Staff staff = staffService.detail(Long.valueOf(id));
        model.addAttribute("staff", staff);

        model.addAttribute("listShop", shopRepository.findAll());
        model.addAttribute("listPosition", positionRepository.findAll());

        model.addAttribute("view", "/WEB-INF/views/staff/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        staffService.delete(Long.valueOf(id));
        return "redirect:/staff/index";
    }
}
