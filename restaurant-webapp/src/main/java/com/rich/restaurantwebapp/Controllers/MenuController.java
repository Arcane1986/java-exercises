package com.rich.restaurantwebapp.Controllers;

import com.rich.restaurantwebapp.Models.Menu;
import com.rich.restaurantwebapp.Models.MenuItem;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "")
public class MenuController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("menus", Menu.getMenus());
        return "index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String CreateMenu(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "createMenu";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String CreateMenu(@RequestParam(required = false) String restaurant, Model model) {
        String restName = restaurant.trim();
        if (!restaurant.isEmpty() && !Menu.duplicateCheck(restName)) {
            Menu menu = new Menu(restName);
            model.addAttribute("menu", menu);
            return "createMenuItem";
        }
        else if(!restaurant.isEmpty() && Menu.duplicateCheck(restName)){
            for (Menu menu:Menu.getMenus()){
                if(menu.getRestaurantName().equals(restName)){
                    ArrayList<MenuItem> menuItems = menu.getMenuItems();
                    model.addAttribute("menu", menu);
                    model.addAttribute("menuItems",menuItems);
                    return "createMenuItem";
                }
            }
        }
        return "redirect:create?error=Restaurant Name Can Not Be Blank";
    }

//    @RequestMapping(value = "create-item", method=RequestMethod.GET)
//    public String CreateItem(HttpServletRequest req, Model model) {


    @RequestMapping(value = "create-item", method = RequestMethod.POST)
    public String CreateItem(HttpServletRequest req, Model model) {
        String name = req.getParameter("item-name").trim();
        String category = req.getParameter("item-category");
        String description = req.getParameter("item-description").trim();
        String price = req.getParameter("item-price").trim();
        String itemNew = req.getParameter("item-new");
        String menuidString = req.getParameter("menu-id");
        Integer menuid = Integer.parseInt(menuidString);

        for (Menu amenu : Menu.getMenus()) {
            if (amenu.getId() == menuid) {
                ArrayList<MenuItem> menuItems = amenu.getMenuItems();
                Menu menu = amenu;

                if (!name.equals("") && !category.equals("") && !description.equals("") && !price.equals("")
                        && !itemNew.equals("") && !menuidString.equals("")) {
                    MenuItem item = new MenuItem(name, category, description, price, itemNew, menuid);
                    menu.addMenuItems(item);
                    menuItems = menu.getMenuItems();
                    model.addAttribute("menu", menu);
                    model.addAttribute("menuItems", menuItems);
                    return "createMenuItem";
                }

                String error = "All fields need to be completed in order to submit Menu Item";
                model.addAttribute("menu", menu);
                model.addAttribute("error", error);
                model.addAttribute("menuItems", menuItems);
                return "createMenuItem";
            }
            }
        return "redirect:create?error=Restaurant Name Can Not Be Blank";
    }

    @RequestMapping(value = "remove-item", method = RequestMethod.POST)
    public String RemoveItem(Model model, @RequestParam(required = false) ArrayList<Integer> removeItem, @RequestParam(required = false) Integer menuid) {
        if(menuid!=null) {
            for (Menu amenu : Menu.getMenus()) {
                if (amenu.getId() == menuid) {
                    Menu menu = amenu;
                    ArrayList<MenuItem> menuItems = amenu.getMenuItems();
                    if(removeItem!=null) {
                        ArrayList<MenuItem> amenuItems = new ArrayList<>(menuItems);
                        for (MenuItem item : amenuItems) {
                            System.out.println(menuItems.toString());
                            if (removeItem.contains(item.getItemid())) {
                                menuItems.remove(item);
                            }
                            System.out.println(menuItems.toString());
                        }
                        model.addAttribute("menu", menu);
                        model.addAttribute("menuItems", menuItems);
                        return "createMenuItem";
                    }
                    String error = "Select a checkbox of the item you wish to remove";
                    model.addAttribute("error",error);
                    model.addAttribute("menu", menu);
                    model.addAttribute("menuItems", menuItems);
                    return "createMenuItem";
                }
            }
        }
        return "redirect:create/?error=Restaurant Name Can Not Be Blank";
    }
}
