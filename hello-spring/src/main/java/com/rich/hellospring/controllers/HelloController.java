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
        return "<form action='/form' method='POST' id='Bonjour'>" +
                "<input type='text' name='name' />" +
                "<select name='language' form='Bonjour'>" +
                "  <option value='english'>English</option>" +
                "  <option value='french'>French</option>" +
                "  <option value='spanish'>Spanish</option>" +
                "  <option value='italian'>Italian</option>"+
                "  <option value='german'>German</option>"+
                "</select>"+
                "<input type='submit' />" +
                "</form>";
    }


    @RequestMapping(value = "form", method = RequestMethod.POST)
    @ResponseBody
    public String helloFormPost (HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String hello;
        if (language.equals("english")) {
            hello = "Hello";
        }
        else if (language.equals("french")) {
            hello = "Bonjour";
        }
        else if (language.equals("spanish")) {
            hello = "Hola";
        }
        else if (language.equals("italian")) {
            hello = "Ciao";
        }
        else{
            hello = "Hallo";
        }

        if (name==null){
            name="Stranger";
        }
        return hello +" "+ name;
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
