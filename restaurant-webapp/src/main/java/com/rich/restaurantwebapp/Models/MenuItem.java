package com.rich.restaurantwebapp.Models;

import java.util.ArrayList;

public class MenuItem {
    private static Integer nextid=1;
    private static ArrayList<MenuItem> items;

    private Integer itemid;
    private String itemName;
    private String itemCategory;
    private String itemDescription;
    private String itemPrice;
    private String itemNew;
    private Integer menuid;

    public static Integer getNextid() {
        return nextid;
    }

    public static ArrayList<MenuItem> getItems() {
        return items;
    }

    public Integer getItemid() {
        return itemid;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemNew() {
        return itemNew;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public MenuItem(String itemName,String itemCategory,String itemDescription, String itemPrice, String itemNew,Integer menuid) {
        this.itemid = nextid++;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemNew=itemNew;
        this.menuid=menuid;
    }
}
