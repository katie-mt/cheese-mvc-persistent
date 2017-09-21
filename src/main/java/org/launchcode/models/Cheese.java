package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */


@Entity
public class Cheese {

    //unique ID annotation
    @Id
    //Hibernate will generate the value of the ID when persisting each object
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    //There can be many cheese for any one category
    @ManyToOne
    //Hibernate will create a column named category_id (comes from field name) and when a Cheese object is stored,
    // this column will contain the id of its category object.  The data for the category object itself will go in the
    // table for the Category class.
    private Category category;

    //configures the other side of the many-to-many relationship.  Field is mapped by the cheeses field of the Menu class
    //Items in this list should correspond to the Menu objects that contain a given Cheese object in their cheeses list.
    //Hibernate will notice that our list contains Menu objects and looks in that class for a property with the same name as that specified by the mappedBy attribute
    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;


    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

}
