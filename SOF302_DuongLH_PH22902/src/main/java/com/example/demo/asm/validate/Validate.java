package com.example.demo.asm.validate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Validate {



    public String inputCode(String code,Model model) {


            if(!code.trim().isEmpty() == false){
                model.addAttribute("code","mã trống");
            }else if((code.length() == Until.CODE_LENGHT ) == false){
                model.addAttribute("code","mã phải 4 kí tự");
            }
            return code;
        }
    }

