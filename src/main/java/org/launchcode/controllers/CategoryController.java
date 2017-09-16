package org.launchcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    //Autowired - Spring creates a class that implements CategoryDao and puts one of those objects in the categoryDao field when the app starts
    @Autowired
    //private field categoryDao of type CategoryDao.  This is the mechanism with which we interact with objects stored in the database
    private CategoryDao categoryDao;

}
