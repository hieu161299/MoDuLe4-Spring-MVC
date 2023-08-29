package com.example.demo_webservice_postman.service;

import com.example.demo_webservice_postman.model.Role;
import com.example.demo_webservice_postman.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role findById(int id){
        return roleRepo.findById(id).get();
    }
}
