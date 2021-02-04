package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/third")
public class Calculator {


    @GetMapping("/calc")
    public String calculate(@RequestParam(required = false) int a,
                            @RequestParam(required = false) int b,
                            @RequestParam(required = false) String action,
                            Model result) throws Exception {

        int total;

        switch (action){
            case "addition": total = a + b;
            break;
            case "subtraction": total = a - b;
            break;
            case "multiplication" : total = a * b;
            break;
            case "division": total =  a / b;
            default: throw  new Exception("Неправильное действие");
        }

        result.addAttribute("result", total);



        return "third/calc";
    }
}
