package com.blog.controller;

import com.blog.model.Category;
import com.blog.model.Counter;
import com.blog.model.News;
import com.blog.service.ICategoryService;
import com.blog.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/news")
@SessionAttributes("counter")
public class NewsController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    INewsService newsService;

    @ModelAttribute("counter")
    public Counter setupCounter(){
        return new Counter();
    }
    @ModelAttribute(name = "categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping  // trang crud
    public ModelAndView home(@RequestParam(defaultValue = "0") int page  ){

        ModelAndView modelAndView = new ModelAndView("homeAdmin");
        Page<News> newsList = newsService.getAll(PageRequest.of(page , 4 ));
        modelAndView.addObject("newsList" , newsList);
        return modelAndView;
    }
    @GetMapping("/showFormAdd")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("formAdd");
        modelAndView.addObject("news", new News());
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute News news , @RequestParam int idCategory) {
        ModelAndView modelAndView = new ModelAndView("redirect:/news");
        newsService.save(news  , idCategory);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/news");
        newsService.delete(id);
        return modelAndView;
    }

    @GetMapping("/formEdit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("formEdit");
        News news = newsService.findById(id);
        modelAndView.addObject("news" , news);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute News news , @RequestParam int idCategory){
        ModelAndView modelAndView = new ModelAndView("redirect:/news");
        newsService.save(news , idCategory);
        return modelAndView;
    }

    @GetMapping("/homePage")
    public ModelAndView showHomePage(@RequestParam(defaultValue = "0") int page){ // trang hiển thị bên người dùng
        ModelAndView modelAndView = new ModelAndView("homePage");
        Page<News> newsList = newsService.getAll(PageRequest.of(page , 4 ));
        modelAndView.addObject("newsList" , newsList);
        return modelAndView;
    }
    @GetMapping("/category/{idCategory}") // hiện thị news theo loại // demo dùng cookie tạo counter luot xem
    public ModelAndView category(@PathVariable int idCategory ){

        ModelAndView modelAndView = new ModelAndView("category" );
        modelAndView.addObject("newsList", newsService.findByCategoryId(idCategory));
        modelAndView.addObject("category" , categoryService.findById(idCategory));
        return modelAndView;
    }
    @GetMapping("/news-detail/{id}")
    public ModelAndView showNewsDetail(@PathVariable int id  , @ModelAttribute("counter") Counter counter){
        counter.increment();
        ModelAndView modelAndView = new ModelAndView("blog-single");
        modelAndView.addObject("news" , newsService.findById(id));
        return modelAndView;
    }
}
