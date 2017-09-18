package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Annotation flags SpringBoot that we want to store this class in the database
//Every field within this class (name, id) will be stored within a table in the database unless otherwise specified
@Entity
//model class
public class Category {

    //id field should be a unique primary key
    @Id
    //Hibernate will generate the id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    //Each category will have many cheeses, each cheese can only have one category
    @OneToMany
    //Tells Hibernate to use the category_id column of the cheese table to determine which cheese belong to a given category
    @JoinColumn(name = "category_id")
    //List represents the list of all items in a given category
    private List<Cheese> cheeses = new ArrayList<>();

    //Hibernate will use this default constructor
    public Category() { }

    //constructor that accepts a parameter to set name
    public Category(String name) {
        this.name = name; }


    //Added this in to see if it fixed categoryDao error (it did not)
    public List<Cheese> getCheeses() {
        return cheeses;
    }

    //only a setter for the id because others should not get able to change the id
    //public void setId(int id) {
    //        this.id = id;
    //    }

    //Added this in to see if it fixed categoryDao error (it did not) - opposite of what you had above
    public int getId() {
        return id;
    }

    //public getter and setter for name
    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

}
