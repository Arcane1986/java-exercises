package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {

//    TODO 1: Create Category Class

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3,max = 25, message = "Category name needs to be greater than 2 characters or less than 25")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public Category() {
    }
}
