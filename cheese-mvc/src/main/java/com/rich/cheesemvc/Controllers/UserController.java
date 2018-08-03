package com.rich.cheesemvc.controllers;

import com.rich.cheesemvc.models.User.User;
import com.rich.cheesemvc.models.User.UserData;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String add(Model model, @ModelAttribute @Valid User newUser, Errors errors, String verify, HttpServletRequest req){
        if (req.getMethod().equals("GET")) {
            model.addAttribute(new User());
            return "user/add";
        }
        HashMap<String,String> otherErrors = newUser.verifyData(verify);
        model.addAttribute("user",newUser);

        if (otherErrors.size()>0){
            model.addAttribute("otherErrors",otherErrors);
            return "user/add";
        }

        if (errors.hasErrors()){
                model.addAttribute("user",newUser);
                return "user/add";
        }

        UserData.addUser(newUser);
        return "redirect:?username="+newUser.getUsername();
    }
}
