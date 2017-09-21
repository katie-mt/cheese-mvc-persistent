package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    //id field should be a unique primary key
    @Id
    //Hibernate will generate the id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    //Sets up half of our many-to-many relationship
    @ManyToMany
    //@JoinColumn(name = "category_id")
    //used to hold all items in the menu.  Hibernate will populate it for us based on the relationships
    //set up in the controllers.
    private List<Cheese> cheeses;


    //Hibernate will use this default constructor
    public Menu() { }

    //constructor that accepts a parameter to set name
    public Menu(String name) {
        this.name = name; }

    //getter and setter for id
    public int getId() {
        return id;
    }

    //public void setId(int id) {
    //    this.id = id;
    //}


    //getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter for cheeses (no setter!)
    public List<Cheese> getCheeses() {
        return cheeses;
    }

    //Method that adds the given object to the list
    public void addItem(Cheese item) { cheeses.add(item); }

    public int getMenuId() { return id; }

    //public void addItem(Cheese item)  {
    //    this.item = item;
    //}

}

