package com.example.demo_webservice_postman.service;

import com.example.demo_webservice_postman.model.Account;
import com.example.demo_webservice_postman.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAll(){
        return (List<Account>) accountRepo.findAll();
    }

    public Account save(Account account){
        return accountRepo.save(account);
    }
    public void delete(int id){
        accountRepo.deleteById(id);
    }
    public void  edit(Account account){
        accountRepo.save(account);
    }

    public Account findById(int id){
        return accountRepo.findAccountById(id);
    }

    public List<Account> findAllByName(String name){
        return accountRepo.findAllByName(name);
    }

    public Account checkAccount(String username , String password){
        return accountRepo.checkAccount(username , password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(username,account.getPassword(),roles);
    }
}
