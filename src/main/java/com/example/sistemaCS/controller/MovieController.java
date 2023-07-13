package com.example.sistemaCS.controller;

import com.example.sistemaCS.model.Movie;
import org.springframework.stereotype.Controller;
import com.example.sistemaCS.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private MovieService ms;
    private Movie m;
    private ArrayList<Movie> movies = new ArrayList<>();

    @GetMapping("/listMovies")
    public ModelAndView listMovies(@RequestBody int id){
        this.movies = ms.listMovies(id);
        System.out.println("movies");
        ModelAndView mv = new ModelAndView("listMovie");
        mv.addObject("movies", movies);
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/addMovie")
    public ModelAndView addMovie(@RequestBody int id){
        ModelAndView mv = new ModelAndView("insertMovie");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/inserMovie")
    public ModelAndView insertMovie(@RequestBody Movie m, int id){
        ms.insertMovie(m, id);
        ModelAndView mv = new ModelAndView("listMovie");
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/editMovie")
    public ModelAndView editMovie(@RequestBody int idMovie, int id){
        m = ms.listMovie(idMovie);
        ModelAndView mv = new ModelAndView("editMovie");
        mv.addObject("movie", m);
        mv.addObject("id", id);
        return mv;
    }

    @PutMapping("/editMovie")
    public ModelAndView editMovie(@RequestBody Movie m, int id){
        ms.editMovie(m);
        ModelAndView mv = new ModelAndView("listMovie");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/deleteMovie")
    public ModelAndView deleteMovie(@RequestBody int idMovie, int id){
        ms.dellMovie(idMovie);
        ModelAndView mv =  new ModelAndView("listMovie");
        mv.addObject("id", id);
        return mv;
    }
}

