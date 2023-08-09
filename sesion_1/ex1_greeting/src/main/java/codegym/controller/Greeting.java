package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Greeting {
    @GetMapping("/greeting")
    public String gretting(String name , Model model){
        model.addAttribute("name" , name);
        return "index";
    }

}
