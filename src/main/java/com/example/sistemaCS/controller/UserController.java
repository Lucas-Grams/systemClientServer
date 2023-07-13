package com.example.sistemaCS.controller;

import com.example.sistemaCS.model.User;
import org.springframework.stereotype.Controller;
import com.example.sistemaCS.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

@Controller
@RequestMapping("")
public class UserController{

    private UserService us;
    private User u;
    private ArrayList<User> users = new ArrayList<>();

    @GetMapping("/index")
    public ModelAndView index(){
        System.out.println("index");
        ModelAndView mv = new ModelAndView("index");
        System.out.println(mv);
        return mv;
    }

}
