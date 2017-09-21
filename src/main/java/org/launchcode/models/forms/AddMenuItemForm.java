package org.launchcode.models.forms;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    //data passed into POST handler, with cheeseId below, will specify the two objects that are related to each other based on the form submission
    @NotNull
    private int menuId;

    //see comment above, also passed into POST handler
    @NotNull
    private int cheeseId;

    //iterable of cheeses, collection of cheeses.  Will render the dropdown (gives user options of what to add to their menu)
    private Iterable<Cheese> cheeses;

    //menu object, will be needed to render form
    private Menu menu;

    //default constructor to assist with model binding
    public AddMenuItemForm() {}

    //constructor used in the GET request handler for this form. Takes in a collection of cheeses and a menu and creates a new form.
    public AddMenuItemForm(Iterable<Cheese> cheeses, Menu menu) {
        this.cheeses = cheeses;
        this.menu = menu;
    }

    //getters and setters
    public int getMenuId() {return menuId; }

    //public void setMenuId(int menuId) { this.menuId = menuId; }

    public int getCheeseId() {return cheeseId;}

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public Menu getMenu() {
        return menu;
    }
}
