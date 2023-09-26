package com.example.demo.asm.controller;

import com.example.demo.asm.entity.Client;
import com.example.demo.asm.entity.Staff;
import com.example.demo.asm.service.ClientService;
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
@RequestMapping(value = "/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,
                        Model model) {

        Pageable pageable = PageRequest.of(number, 5);
        Page<Client> pageClient = clientService.getAll(pageable);
        model.addAttribute("listClient", pageClient);
        model.addAttribute("view", "/WEB-INF/views/client/index.jsp");
        return "layout";

    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("client", new Client());

        model.addAttribute("view", "/WEB-INF/views/client/view-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/views/client/view-add.jsp");
            return "layout";
        }else {
            clientService.add(client);
        }

        return "redirect:/client/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,Model model){
        model.addAttribute("client", new Client());

        Client client = clientService.detail(Long.valueOf(id));
        model.addAttribute("client", client);

        model.addAttribute("view", "/WEB-INF/views/client/detail.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        clientService.delete(Long.valueOf(id));
        return "redirect:/client/index";
    }

    @GetMapping("/view-update")
    public String viewupdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("client", new Client());

        Client client = clientService.detail(Long.valueOf(id));
        model.addAttribute("client", client);

        model.addAttribute("view", "/WEB-INF/views/client/view-update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("client") Client client,
                         @RequestParam("id") String id
    ) {

        clientService.update(client,Long.valueOf(id));
        return "redirect:/client/index";
    }


}
