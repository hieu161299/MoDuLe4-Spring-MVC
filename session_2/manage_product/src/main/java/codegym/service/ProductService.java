package codegym.service;

import codegym.database.ConnectionToMySQL;
import codegym.model.Product;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Connection connection = ConnectionToMySQL.getConnection();

    public void add(Product product) {
        String sql = "insert into products (name, price, quantity , img) values (? , ? , ? , ? );";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Product product) {
        int index = findIndexById(product.getId());
        String sql = "UPDATE products\n" +
                "SET name     = ?,\n" +
                "    price    = ?,\n" +
                "    quantity = ?,\n" +
                "    img      = ?\n" +
                "WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString( 1 , product.getName());
            preparedStatement.setDouble(2 , product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4,product.getImage());
            preparedStatement.setInt(5,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        String sql = "select * from products order by id;";
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String img = resultSet.getString("img");
                Product product = new Product(id, name, price, quantity, img);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product findById(int id) {
        Product product = new Product();
        for (Product p : getAll()) {
            if (id == p.getId()) {
                product = p;
            }
        }
        return product;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < getAll().size(); i++) {
            if (id == getAll().get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public List<Product> findByName(String name){
        List<Product> searchList = new ArrayList<>();
        for (Product p: getAll() ) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                searchList.add(p);
            }
        }
        return searchList;
    }
}
