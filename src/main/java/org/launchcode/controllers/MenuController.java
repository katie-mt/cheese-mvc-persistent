package org.launchcode.controllers;


import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
