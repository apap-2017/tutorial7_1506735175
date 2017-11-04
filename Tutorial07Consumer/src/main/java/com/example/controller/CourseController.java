package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController
{
    @Autowired
    CourseService courseDAO;

    /*
    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }
    */

    @RequestMapping("/course/view/{id}")
    public String viewCourse (Model model,
    		@PathVariable(value = "id") String idcourse) {
    
    	CourseModel course = courseDAO.selectCourse (idcourse);
        if (course != null) {
            model.addAttribute ("course", course);
            return "viewforcourse";
        } else {
            model.addAttribute ("id", idcourse);
            return "not-found";
        }    	
    		
    }
      
}








