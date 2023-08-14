package com.controller;

import com.model.Staff;
import com.service.BrandService;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService ;
    @Autowired
    BrandService brandService;
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffList" , staffService.getAll());
        return modelAndView;
    }
    @GetMapping("showFormAdd")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("formAdd");
        modelAndView.addObject("brandList",brandService.getAll());
        modelAndView.addObject("staff" , new Staff());
        return modelAndView;
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Staff staff , MultipartFile fileImg){

        try {
            String nameFile = fileImg.getOriginalFilename();
            fileImg.transferTo(new File("G:/MODUL4-SPRING-MVC/session_3/manage_staff/src/main/webapp/image/" + nameFile));

            staff.setImage(nameFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        staffService.add(staff);
        return "redirect:/staff";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        staffService.delete(id);
        return  modelAndView;
    }
    @GetMapping("/formEdit/{id}")
    public ModelAndView formEdit(@PathVariable int id){
        Staff staff = staffService.findById(id);

        ModelAndView modelAndView = new ModelAndView("formEdit");
        modelAndView.addObject("staff" , staff);
        modelAndView.addObject("brandList",brandService.getAll());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Staff staff){
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        Staff newStaff = new Staff(staff.getId() , staff.getName() , staff.getAge() , staff.getSalary() , staff.getIdBrand());
        staffService.edit(newStaff);
        return modelAndView;
    }
    @GetMapping("/information/{id}")
    public ModelAndView showInformation(@PathVariable int id){
        Staff staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("information");
        modelAndView.addObject("staff" , staff);
        return modelAndView;
    }
}
