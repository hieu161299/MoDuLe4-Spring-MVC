package com.service;

import com.database.ConnectionToMySQL;
import com.model.Brand;
import com.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandService {
    Connection connection = ConnectionToMySQL.getConnection();
    public List<Brand> getAll(){
        List<Brand> brandList = new ArrayList<>();
        String  sql = "select * from brand ;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int idBrand = resultSet.getInt("id");
                String brandName = resultSet.getString("brandName");
                Brand brand = new Brand(idBrand , brandName);
               brandList.add(brand);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }

}
