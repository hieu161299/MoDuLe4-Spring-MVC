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

public class StaffService {
    Connection connection = ConnectionToMySQL.getConnection();
    public void add(Staff staff){
        String sql = "insert into  staff ( nameStaff, age, salary,image, idBrand)\n" +
                "values (? , ? , ?, ? , ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getName());
            preparedStatement.setInt(2,staff.getAge());
            preparedStatement.setDouble(3,staff.getSalary());
            preparedStatement.setString(4,staff.getImage());
            preparedStatement.setInt(5,staff.getIdBrand());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Staff> getAll(){
        List<Staff> staffList = new ArrayList<>();
        String  sql = "select staff.* , b.brandName from staff join brand b on b.id = staff.idBrand;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameStaff = resultSet.getString("nameStaff");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                String image = resultSet.getString("image");
                int idBrand = resultSet.getInt("idBrand");
                String brandName = resultSet.getString("brandName");
                Brand brand = new Brand(idBrand , brandName);
                Staff staff = new Staff(id , nameStaff , age , salary , image , brand);
                staffList.add(staff);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }

    public void delete(int id){
        String sql = "delete from staff where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void edit(Staff staff){
        String sql = "UPDATE staff SET nameStaff = ?, age = ? , salary = ? , idBrand = ?  WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , staff.getName());
            preparedStatement.setInt(2, staff.getAge());
            preparedStatement.setDouble(3, staff.getSalary());
            preparedStatement.setInt(4, staff.getIdBrand());
            preparedStatement.setInt(5, staff.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Staff findById(int id){
        Staff staff = new Staff();
        for (Staff s: getAll() ) {
            if (id == s.getId()){
                staff = s;
            }
        }
        return staff;
    }

}
