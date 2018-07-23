package com.rich.cheesemvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestParam String cheeseName) {
        if(!cheeseName.trim().equals("")){
        cheeses.add(cheeseName.trim());}
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String remove(Model model) {
        model.addAttribute("title", "Remove Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String remove(@RequestParam(required = false) String[] removeCheese) {
        if (removeCheese != null) {
            for (String cheese : removeCheese) {
                if (!cheese.equals(null)) {
                    cheeses.remove(cheese);
                }
            }
        }
        return "redirect:";
    }
}