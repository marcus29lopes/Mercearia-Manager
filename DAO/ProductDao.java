package DAO;

import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    private static final DAO<Product> dao = new DAO<Product>(DatabaseConnection.getConnection());

    public static void addDao(Product product) {
        String sql = "INSERT INTO produto (nome, preco, quantidade_em_estoque, categoria_id) VALUES (?, ?, ?, ?)";
        int id = dao.add(sql, product.getName(), product.getPrice(), product.getQuantityInStock(), product.getCategoryId());
        product.setId(id);
    }

    public static List<Product> listar() {
        String sql = "SELECT * FROM pessoa";
        dao.listar();
        return null;
    }

    public static void attNameDao(String name, int id) {
        String sql = "UPDATE produto SET nome = ? WHERE id = ?";
        dao.att(sql, name, id);
    }

    public static void deleteDao(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        dao.delete(sql, id);
    }

    private Product extractProduct(ResultSet resultado) {
        try {
            return new Product(resultado.getInt("id"), resultado.getString("nome"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
