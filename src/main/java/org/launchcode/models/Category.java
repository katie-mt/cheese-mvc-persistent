package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    //Hibernate will use this default constructor
    public Category() { }

    //constructor that accepts a parameter to set name
    public Category(String name) {
        this.name = name; }

    //only a setter for the id because others should not get able to change the id
    public void setId(int id) {
            this.id = id;
        }

    //public getter and setter for name
    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }
}
