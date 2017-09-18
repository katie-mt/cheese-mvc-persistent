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

        //returns a collection of all category objects managed by categoryDao
        menuDao.findAll();
        //object that can be looped over that will provide all the menu items in the database
        model.addAttribute("menu", menuDao.findAll());

        return "menu/index";
    }
}
