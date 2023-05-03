package com.example.fakpge;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/register")
    public String register(FormData formData, Model model) {
        String field1 = formData.getField1();
        String field2 = formData.getField2();
        try (FileWriter writer = new FileWriter("registro.txt", true)) {
            writer.write(field1 + "," + field2 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "Registration successful");
        return "index";
    }
}
