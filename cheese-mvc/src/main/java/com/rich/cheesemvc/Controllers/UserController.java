package com.rich.cheesemvc.controllers;

import com.rich.cheesemvc.models.User.UserData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.rich.cheesemvc.User.User;

import java.util.HashMap;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@RequestParam (required = false) String username, Model model){
        model.addAttribute("username", username);
        model.addAttribute("users", UserData.getUsers());
        return "user/index";
    }

    @RequestMapping(value = "/{id}")
    public String profile(@PathVariable String id, Model model){
        int i = Integer.parseInt(id.trim());
        model.addAttribute("user",UserData.getUser(i));
        return "user/profile";
    }

    @RequestMapping(value="/add", method = { RequestMethod.POST, RequestMethod.GET})
    public String add(Model model, @ModelAttribute User user, String verify, HttpServletRequest req){
        if (req.getMethod().equals("GET"))return "user/add";

        HashMap<String,String> errors = user.verifyData(verify);
        model.addAttribute("user",user);

        if (errors.size()>0){
            model.addAttribute("errors",errors);
            return "user/add";
        }

        UserData.addUser(user);
        return "redirect:?username="+user.getUsername();
    }
}
