package com.demo_spring_mvc.controller;

import com.demo_spring_mvc.model.Product;
import com.demo_spring_mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // thêm @Controller để biết đây là controller
public class Home {
    @Autowired
    private ProductService productService ; // đang null
    // để lấy list có giá trị từ ProductService
    // khi gọi ProductService thì lấy List<Product> productList ở đâu ?????
    // vào file dispatcher-servlet.xml cấu hình cho Spring cái List<Product> productList là cái gì
   /* <!--

    <bean class="com.demo_spring_mvc.service.ProductService" name="productService"></bean>

    -->*/
    // sau đó thêm  @Autowired ở trên private ProductService productService ; để nó xác đinh productService

    @GetMapping("/products")
    public String home(Model model){
        model.addAttribute("productList" , productService.findAll());
        return "products";
    }
    @GetMapping("/products/showFormAdd")
    public String add(){
        return "showFormAdd";
    }
    @GetMapping("/products/delete")
    public String delete(int idProduct){
        productService.delete(idProduct);
        return "redirect:/products";
    }
    @GetMapping("/products/formEdit")
    public String showFormEdit(int idProduct , Model model){
        Product product = productService.findProductById(idProduct);
        model.addAttribute("product" , product);
        return "formEdit";
    }
    @GetMapping("/products/search")
    public String search(String name, Model model){
        model.addAttribute("productList" , productService.searchByName(name));
        return "search";
    }
    @PostMapping("/products/edit")
    public String edit(int id , String name , int price , String img){
        Product product = new Product(id , name , price , img);
        productService.edit(product);
        return "redirect:/products";
    }
    @PostMapping("/products/add")
    public String add(int id , String name , int price , String img){
        Product product = new Product(id , name , price , img);
        productService.add(product);
        return "redirect:/products";
    }
}
