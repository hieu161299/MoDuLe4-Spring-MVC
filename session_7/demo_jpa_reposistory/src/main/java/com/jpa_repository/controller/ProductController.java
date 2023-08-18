package com.jpa_repository.controller;

import com.jpa_repository.model.Category;
import com.jpa_repository.model.Product;
import com.jpa_repository.service.ICategoryService;
import com.jpa_repository.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;
    private final ICategoryService categoryService;

    public ProductController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @ModelAttribute(name = "categories")
    public List<Category> categories(){
        return categoryService.getAll();
    }
    @GetMapping
    public ModelAndView home(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("home");
        Page<Product> products = productService.getAll(PageRequest.of(page , 2  , Sort.by("price")));
        modelAndView.addObject("products" , products);
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
        productService.save(product , idCategory);
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
        productService.save(product , idCategory);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.delete(id);
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String nameSearch ,@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("home");
       /* List<Product> products = productService.getAllByName(nameSearch);
        modelAndView.addObject("products" , products);*/

        Page<Product> products = productService.getAll(nameSearch , PageRequest.of(page , 2));
        modelAndView.addObject("products" , products);
        return modelAndView;
    }

}
