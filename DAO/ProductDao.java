package DAO;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    private static DataAccessObject<Product> dao = new DataAccessObject<>(DatabaseConnection.getConnection());

    public static void insertProduct(Product product) {
        String sql = "INSERT INTO produto (nome, preco, quantidade_em_estoque, categoria_id) VALUES (?, ?, ?, ?)";
        int id = dao.add(sql, product.getName(), product.getPrice(), product.getQuantityInStock(), product.getCategoryId());
        product.setId(id);
    }


}

