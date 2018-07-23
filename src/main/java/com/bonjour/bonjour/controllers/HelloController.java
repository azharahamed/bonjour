package com.bonjour.bonjour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {
    public static String[] languages = {"English", "French", "Spanish", "Portuguese"};

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("languages", languages);
        return "index";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String indexPost(Model model, HttpServletRequest request){

        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String returnString = new String();
        switch(language){
            case "English":
                returnString = "Hello, " + name + "!";
                break;
            case "French":
                returnString = "Bonjour, " + name + "!";
                break;
            case "Spanish":
                returnString = "Hola, " + name + "!";
                break;
            case "Portuguese":
                returnString = "Olá, "  + name + "!";
        }
        model.addAttribute("languages", languages);
        model.addAttribute("returnString", returnString);
        return "index";
    }
}
