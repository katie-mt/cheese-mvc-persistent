package org.launchcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("category")
public class CategoryController {

    //Autowired - Spring creates a class that implements CategoryDao and puts one of those objects in the categoryDao field when the app starts
    @Autowired
    //private field categoryDao of type CategoryDao.  This is the mechanism with which we interact with objects stored in the database
    private CategoryDao categoryDao;

    // Request path: /category
    @RequestMapping(value = "")
    public String index(Model model) {
        //returns a collection of all category objects managed by categoryDao
        categoryDao.findAll();
        //object that can be looped over that will provide all the cheeses in the database
        model.addAttribute("categories", categoryDao.findAll());
        return "jobs/category";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String Category(Model model) {
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute(new Category());
        model.addAttribute("title", "Add Category");
        return "category/add"
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors)

        if (errors.hasErrors()) {
        model.addAttribute("title", "Add Cheese");
        return "category/add";

        //save a new entity
        categoryDao.save(category);
        return "redirect:";
}