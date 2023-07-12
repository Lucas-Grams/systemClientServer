package com.example.sistemaCS.controller;

import com.example.sistemaCS.model.Cartoon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.sistemaCS.service.CartoonService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/cartoon")
public class CartoonController {

    private CartoonService cs;
    private Cartoon c = new Cartoon();
    private ArrayList<Cartoon> cartoons = new ArrayList<>();

    @GetMapping("/listCartoons")
    public ModelAndView listCartoons(@RequestBody int id){
        this.cartoons = cs.listCartoons(id);
        ModelAndView mv = new ModelAndView("listCartoon");
        mv.addObject("cartoons", cartoons);
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/addCartoon")
    public ModelAndView addCartoon(@RequestBody int id){
        ModelAndView mv = new ModelAndView("insertCartoon");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/insertCartoon")
    public ModelAndView insertCartoon(@RequestBody Cartoon c, int id){
        cs.insertCartoon(c, id);
        ModelAndView mv = new ModelAndView("listCartoon");
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/editCartoon")
    public ModelAndView editCartoon(@RequestBody int idCartoon, int id){
        c = cs.listCartoon(idCartoon);
        ModelAndView mv = new ModelAndView("editCartoon");
        mv.addObject("cartoon", c);
        mv.addObject("id", id);
        return mv;
    }

    @PutMapping("/editCartoon")
    public ModelAndView editCartoon(@RequestBody Cartoon c, int id){
        cs.insertCartoon(c, id);
        ModelAndView mv = new ModelAndView("listCartoon");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/deleteCartoon")
    public ModelAndView deleteCartoon(@RequestBody int idCartoon, int id){
        ModelAndView mv = new ModelAndView("listCartoon");
        mv.addObject("id", id);
        cs.dellCartoon(idCartoon);
        return mv;
    }
}