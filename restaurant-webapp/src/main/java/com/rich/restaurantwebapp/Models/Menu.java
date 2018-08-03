package com.rich.restaurantwebapp.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Menu {
    private static Integer nextid=1;
    private static ArrayList<Menu> menus = new ArrayList<>();

    private Integer id;
    private String restaurantName;
    private String updatedOn;
    private ArrayList<MenuItem> menuItems;

    public static Integer getNextid() {
        return nextid;
    }

    public static ArrayList<Menu> getMenus() {
        return menus;
    }

    public static void addMenus(Menu menu) {
        if (!menus.contains(menu)) {
            menus.add(menu);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName.trim();
    }

    public static Boolean duplicateCheck(String Name){
        Boolean isDuplicate = false;
        for (Menu menu:Menu.getMenus()){
            if(menu.restaurantName.equals(Name)){
                isDuplicate = true;
                return isDuplicate;
            }
        }
        return isDuplicate;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    private void setUpdatedOn() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.updatedOn = dtf.format(now);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItems(MenuItem item) {
        this.menuItems.add(item);
    }

    public void removeMenuItems(MenuItem item) {
        this.menuItems.remove(item);
    }

    public Menu(String restaurantName){
        this.setUpdatedOn();
        this.id=nextid++;
        this.setRestaurantName(restaurantName);
        this.menuItems=new ArrayList<>();

        Menu.addMenus(this);

        System.out.println(this);
    }
}

