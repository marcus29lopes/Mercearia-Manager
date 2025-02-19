package DAO;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    public static void insertProduct(Product product) throws SQLException {
        String sql = "INSERT INTO produto (nome, preco, quantidade_em_estoque, categoria_id) VALUES (?, ?, ?, ?)";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) {
            throw new IllegalStateException("Falha ao obter conexão com o banco de dados");
        }
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, product.getName());
        stmt.setBigDecimal(2, product.getPrice());
        stmt.setInt(3, product.getQuantityInStock());
        stmt.setInt(4, product.getCategoryId());

        stmt.executeUpdate();





        // adicionar tabela categoria e valores
        //criar entidade categoria
        //listar produtos


    }


}

