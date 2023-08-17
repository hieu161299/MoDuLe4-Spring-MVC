package com.demo_jpa.controller;

import com.demo_jpa.model.Category;
import com.demo_jpa.model.Product;
import com.demo_jpa.service.CategoryService;
import com.demo_jpa.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService productService ;
    CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @ModelAttribute("categories")
    public List<Category> categories(){
       return categoryService.getAll();
    }
    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products" , productService.getAll());
        return modelAndView;
    }
    @GetMapping("/showFormAdd")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("formAdd");
        modelAndView.addObject("product" , new Product());
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute Product product , @RequestParam int idCategory){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        Category category = categoryService.findById(idCategory);
        product.setCategory(category);
        productService.add(product);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete( @PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
            Product product = productService.findById(id);
            productService.delete(product);
        return modelAndView;
    }
    @GetMapping("/formEdit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("formEdit");
        Product product = productService.findById(id);
        modelAndView.addObject("product" , product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Product product , @RequestParam int idCategory){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        Category category = categoryService.findById(idCategory);
        product.setCategory(category);
        productService.edit(product);
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search( @RequestParam String nameSearch){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Product> products = productService.findByName(nameSearch);
        modelAndView.addObject("products" , products);
        return modelAndView;
    }
    @GetMapping("/descPrice")
    public ModelAndView sortDESC( ){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products" , productService.desc());
        return modelAndView;
    }

}
