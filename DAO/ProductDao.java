package DAO;

import model.Product;

public class ProductDao {
    private static final DataAccessObject<Product> dao = new DataAccessObject<>(DatabaseConnection.getConnection());

    public static void addDao(Product product) {
        String sql = "INSERT INTO produto (nome, preco, quantidade_em_estoque, categoria_id) VALUES (?, ?, ?, ?)";
        int id = dao.add(sql, product.getName(), product.getPrice(), product.getQuantityInStock(), product.getCategoryId());
        product.setId(id);
    }

    public static void attNameDao(String name, int id){
        String sql = "UPDATE produto SET nome = ? WHERE id = ?";
        dao.att(sql, name, id);
    }

    public static void deleteDao(int id){
        String sql = "DELETE FROM produto WHERE id = ?";
        dao.delete(sql, id);
    }



}

