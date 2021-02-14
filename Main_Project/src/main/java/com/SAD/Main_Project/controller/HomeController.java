package com.SAD.Main_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static String HOME_PAGE = "home.jsp";

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView(HOME_PAGE);

        return mv;
    }

}
