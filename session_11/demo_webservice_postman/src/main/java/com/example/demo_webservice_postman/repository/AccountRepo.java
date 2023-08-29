package com.example.demo_webservice_postman.repository;

import com.example.demo_webservice_postman.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account , Integer> {

    public Account findAccountById(int id);

    @Query(nativeQuery = true , value = "select * from account where username like concat('%', :name , '%')")
    List<Account> findAllByName(@Param( "name") String name);
    @Query(value = "select  a from  Account a where a.username =:username and a.password =:password")
    Account checkAccount(@Param("username") String username, @Param("password") String password);

    Account findByUsername(String username);
}
