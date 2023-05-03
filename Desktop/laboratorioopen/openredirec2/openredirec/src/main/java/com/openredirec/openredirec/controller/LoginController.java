package com.openredirec.openredirec.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return "search";
        } else {
            return "login";
        }
    }

    
    @GetMapping("/search")
    public String showSearchPage() {
        return "teste";
    }
    
    @GetMapping("/redirect")
    public RedirectView simpleRedirect(@RequestParam("url") String target) {
        RedirectView redirectView = new RedirectView();
        //target = "1.html";
        redirectView.setUrl(target);
        return redirectView;
    }

    @GetMapping("/search/{cpf}")
public String searchCpf(@PathVariable String cpf) {
    String cpfWithoutDots = cpf.replaceAll("\\.", "");
    String cpfWithoutDashes = cpfWithoutDots.replaceAll("-", "");
    String pageName = cpfWithoutDashes + ".html";
    InputStream pageStream = getClass().getResourceAsStream("/cpf/" + pageName);
    if (pageStream != null) {
        return "redirect:/cpf/" + pageName;
    } else {
        return "cpf-not-found";
    }
}

}



