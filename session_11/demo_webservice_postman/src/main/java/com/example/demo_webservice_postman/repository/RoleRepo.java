package com.example.demo_webservice_postman.repository;

import com.example.demo_webservice_postman.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
}
