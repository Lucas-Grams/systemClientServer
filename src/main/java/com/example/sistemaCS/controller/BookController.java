package com.example.sistemaCS.controller;


import com.example.sistemaCS.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.sistemaCS.service.BookService;
import java.util.ArrayList;

@Controller
@RequestMapping("/book")
public class BookController{
    private BookService bs;
    private Book b = new Book();
    private ArrayList<Book> books = new ArrayList<>();

    @GetMapping("/listBooks")
    public ModelAndView listBooks(@RequestBody int id){
       this.books = bs.listBooks(id);
        ModelAndView mv = new ModelAndView("listBook");
        mv.addObject("books", books );
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/addBook")
    public ModelAndView addBook(@RequestBody int id){
        ModelAndView mv = new ModelAndView("insertBoook");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/insertBook")
    public ModelAndView insertBook(@RequestBody Book b, int id){
        bs.insertBook(b, id);
        ModelAndView mv = new ModelAndView("listBook");
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("/editBook")
    public ModelAndView editBook(@RequestBody int idBook, int id){
        b = bs.listBook(idBook);
        ModelAndView mv = new ModelAndView("editBook");
        mv.addObject("idBook", idBook);
        mv.addObject("id", id);
        return mv;
    }

    @PutMapping("/editBook")
    public ModelAndView editBook(@RequestBody Book b, int id){
        bs.editBook(b);
        ModelAndView mv= new ModelAndView("listBook");
        mv.addObject("id", id);
        return mv;
    }

    @PostMapping("/deleteBook")
    public ModelAndView deleteBook(@RequestBody int idBook, int id){
        ModelAndView mv = new ModelAndView("listBook");
        mv.addObject("id", id);
        bs.dellBook(idBook);
        return mv;
    }
}