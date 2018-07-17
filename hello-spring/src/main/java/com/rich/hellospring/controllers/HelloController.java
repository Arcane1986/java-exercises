package com.rich.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(HttpServletRequest request) {
        return "<form action='/form' method='POST'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' />" +
                "</form>";
    }


    @RequestMapping(value = "form", method = RequestMethod.POST)
    @ResponseBody
    public String helloFormPost (HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == "") {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "reroute", method = RequestMethod.GET)
    public String reroute () {
        String name = "Johnny";
        return "redirect:/dynamic/"+name;
    }

    @RequestMapping(value = "dynamic/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String dynamic (@PathVariable String name) {
        return name;
    }
}
