package com.example.demo_webservice_postman.controller;

import com.example.demo_webservice_postman.model.Account;
import com.example.demo_webservice_postman.service.AccountService;
import com.example.demo_webservice_postman.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")// muốn xóa thì để @DeleteMapping
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        accountService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id){
        return accountService.findById(id);
    }

    @GetMapping("/search/{name}")
    public List<Account> searchList(@PathVariable String name){
        return accountService.findAllByName(name);
    }
    @PostMapping("/checkAccount")
    public Account checkAccount(@RequestParam String username , @RequestParam String password){
        return  accountService.checkAccount(username , password);
    }


}
