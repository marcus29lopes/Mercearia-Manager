package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {
    public static void addCategory(String name) throws SQLException {

        //Apagar adicionar categoria depois
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
        stmt.setString(1, name);

        stmt.execute();
        System.out.println("Categoria incluida com sucesso!");
        stmt.close();


    }



}
