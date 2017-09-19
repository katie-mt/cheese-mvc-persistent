package org.launchcode.controllers;


import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        //object that can be looped over that will provide all the menu items in the database
        //returns a collection of all category objects managed by categoryDao
        model.addAttribute("title", "Menus");
        //under the attribute name "menus", pass the results of passing meuDao.findAll()
        model.addAttribute("menus", menuDao.findAll());

        return "menu/index/";
    }

    //available at menu/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        //adds a title
        model.addAttribute("title", "Add Menu");
        //passes a new menu item into the view
        model.addAttribute(new Menu());
        return "menu/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Menu menu, Errors errors) {

        //if we have errors, go back to add form and show error message
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";

        }

        //save new menu object
        menuDao.save(menu);

        //redirect to display the new menu item
        return "redirect:view/" + menu.getId();
    }

    //display contents of a single menu
    //path is view/the id of the menuId

    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuID) {

        //fetch the particular menu that we're looking at
        Menu menu = menuDao.findOne(menuID);
        //title/name of menu
        model.addAttribute("title", menu.getName())
        //all cheeses part of the menu and pass into the view
        model.addAttribute("cheeses", menu.getCheeses());
        //grab specific id of the menu
        model.addAttribute("menuId", menu.getId());

        return "menu/view";
    }
}
