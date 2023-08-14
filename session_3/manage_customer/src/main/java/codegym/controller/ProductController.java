package codegym.controller;

import codegym.model.Product;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products") // quy định chung cho các url khi muốn dùng phương thức bên trong
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String showAll(Model model){
        model.addAttribute("products" , productService.getAll());
        return "home";
    }
    @GetMapping("/showFormAdd")
    public String showFormAll(Model model){
        return "formAdd";
    }
  /*  @PostMapping("add")
    public String add(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:/products";
        // Cách 1 : sử dụng @ModelAttribute để nhận gi tring từ form add gửi về
        // bước 1 : @ModelAttribute tạo 1 đối tượng Product với constructor ko tham số nên Class Product phải có constructor ko tham số
        // bước 2 : @ModelAttribute mapping với các param cùng tên với thuộc tính của Product ( vì vậy tên param phải trùng với tên thuộc tính
        // ví dụ : Product có thuộc tính  tên là (quantity) thì param bắt buộc đặt tên là (quantity) thì @ModelAttribute mới có thể mapping dc giá trị
    }*/
    @PostMapping("add")
    public String add( String name ,  double price ,  int quantity ,  String image){
        Product product = new Product(name , price , quantity , image);
        productService.add(product);
        return "redirect:/products";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("formEdit")
    public String formEdit( int id , Model model){
        Product product = productService.findById(id);
        model.addAttribute("product" , product);
        return "formEdit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Product product){
        productService.edit(product);
        return "redirect:/products";
    }
    @GetMapping("search")
    public String serach( String nameSearch , Model model){
        model.addAttribute("products" , productService.findByName(nameSearch));
        return "home";
    }


}
